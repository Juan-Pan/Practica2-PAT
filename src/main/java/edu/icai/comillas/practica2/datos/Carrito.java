package edu.icai.comillas.practica2.datos;


public record Carrito(
        Long idCarrito,
        String idArticulo,
        String descripcion,
        Integer numeroUnidades,
        Double precioFinal
) {
    public Carrito withId(Long nuevoId) {
        return new Carrito (nuevoId,idArticulo, descripcion, numeroUnidades, precioFinal);
    }

}
