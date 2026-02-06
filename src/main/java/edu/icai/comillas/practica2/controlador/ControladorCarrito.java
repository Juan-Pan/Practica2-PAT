package edu.icai.comillas.practica2.controlador;
import edu.icai.comillas.practica2.datos.Carrito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/carrito")
public class ControladorCarrito {
    //aca se crea una base de datos falsa con el concurrentHashMap
    //se utiliza el concurrentHashMap porque si dos personas a la vez quieren comprar el mismo articulo, no se va a caer la aplicacion
    //clave: id del carrito, valor: carrito
    private final Map<Long, Carrito> baseDeDatos = new ConcurrentHashMap<>();
    //crear contador para generar ids unicos
    private final AtomicInteger id = new AtomicInteger(0);

    //crear carrito
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
   public Carrito crearCarrito(@RequestBody Carrito carritoNuevo) {
        Long nuevoId = (long) id.incrementAndGet();
        Carrito carritoConId = carritoNuevo.withId(nuevoId);
        baseDeDatos.put(nuevoId, carritoConId);
        return carritoConId;
    }
    //obtener carrito
    @GetMapping("/{idCarrito}")
    public Carrito obtenerCarrito(@PathVariable Long idCarrito) {
        if(baseDeDatos.get(idCarrito) == null) {
            throw new RuntimeException("Carrito no encontrado");
        }
        return baseDeDatos.get(idCarrito);
    }

    //actualizar carrito
    @PutMapping("/{idCarrito}")
    @ResponseStatus(HttpStatus.ACCEPTED) //
    public Carrito actualizar(@PathVariable Long idCarrito, @RequestBody Carrito carritoEditado) {


        if (baseDeDatos.get(idCarrito) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El carrito con id " + id + " no existe");
        }


        Carrito carritoDefinitivo = carritoEditado.withId(idCarrito);

        baseDeDatos.put(idCarrito, carritoDefinitivo);

        return carritoDefinitivo;
    }
    //eliminar carrito
    @DeleteMapping("/{idCarrito}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarCarrito(@PathVariable Long idCarrito) {
        if(!baseDeDatos.containsKey(idCarrito)) {

        throw new RuntimeException("EL carrito con id " + idCarrito + " no existe");}
        baseDeDatos.remove(idCarrito);

    }


}


