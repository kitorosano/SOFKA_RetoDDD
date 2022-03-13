package uy.com.sofka.biblioteca.categoria;

import java.util.HashSet;

import co.com.sofka.domain.generic.EventChange;
import uy.com.sofka.biblioteca.categoria.events.*;

public class CategoriaChange extends EventChange {
  
  public CategoriaChange(Categoria categoria){

    apply((CategoriaCreada event) -> {
      categoria.nombre = event.getNombre();
      categoria.libros = new HashSet<Libro>();
    });
    
    apply((NombreModificado event) -> {
      categoria.nombre = event.getNombre();
    });

    apply((LibroAgregado event) -> {
      categoria.libros.add(new Libro(
          event.getLibroId(),
          event.getEditorialId(),
          event.getAutorId(),
          event.getTitulo(),
          event.getAcotacion(),
          event.getGeneros(),
          event.getTema(),
          event.getEstado(),
          event.getCopias()
      ));
    });

    apply((LibroQuitado event) -> {
      categoria.getLibroPorId(event.getLibroId())
          .orElseThrow(() -> new IllegalArgumentException("No se encuentra el libro de la categoria"));
      categoria.libros.removeIf(libro -> libro.identity().equals(event.getLibroId()));
    });

    apply((TituloLibroModificado event) -> {
      var libro = categoria.getLibroPorId(event.getLibroId())
              .orElseThrow(() -> new IllegalArgumentException("No se encuentra el libro de la categoria"));
      libro.modificarTitulo(event.getTitulo());
    });

    apply((AcotacionLibroModificada event) -> {
      var libro = categoria.getLibroPorId(event.getLibroId())
              .orElseThrow(() -> new IllegalArgumentException("No se encuentra el libro de la categoria"));
      libro.modificarAcotacion(event.getAcotacion());
    });

    apply((GeneroLibroAgregado event) -> {
      var libro = categoria.getLibroPorId(event.getLibroId())
              .orElseThrow(() -> new IllegalArgumentException("No se encuentra el libro de la categoria"));
      libro.AgregarGenero(event.getGenero());
    });

    apply((GeneroLibroQuitado event) -> {
      var libro = categoria.getLibroPorId(event.getLibroId())
              .orElseThrow(() -> new IllegalArgumentException("No se encuentra el libro de la categoria"));
      libro.QuitarGenero(event.getGenero());
    });

    apply((TemaLibroModificado event) -> {
      var libro = categoria.getLibroPorId(event.getLibroId())
              .orElseThrow(() -> new IllegalArgumentException("No se encuentra el libro de la categoria"));
      libro.modificarTema(event.getTema());
    });

    apply((EstadoLibroModificado event) -> {
      var libro = categoria.getLibroPorId(event.getLibroId())
              .orElseThrow(() -> new IllegalArgumentException("No se encuentra el libro de la categoria"));
      libro.modificarEstado(event.getEstado());
    });

    apply((CopiasLibroGeneradas event) -> {
      var libro = categoria.getLibroPorId(event.getLibroId())
              .orElseThrow(() -> new IllegalArgumentException("No se encuentra el libro de la categoria"));
      libro.GenerarCopias(event.getCopias());
    });

    apply((CopiasLibroRemovidas event) -> {
      var libro = categoria.getLibroPorId(event.getLibroId())
              .orElseThrow(() -> new IllegalArgumentException("No se encuentra el libro de la categoria"));
      libro.RemoverCopias(event.getCopias());
    });

    apply((BloqueAsignado event) -> {
      if(event.getPasillos().isEmpty())
        throw new IllegalArgumentException("Los pasillos del bloque no pueden estar vacios");
      categoria.bloque = new Bloque(
          event.getBloqueId(),
          event.getDescripcion(),
          event.getPasillos(),
          event.getCantidadEstanterias()
      );
    });

    apply((DescripcionBloqueModificada event) -> {
      if(!categoria.bloque().identity().equals(event.getBloqueId()))
        throw new IllegalArgumentException("El bloque no coincide con el de la categoria");
      categoria.bloque().modificarDescripcion(event.getDescripcion());
    });

    apply((PasilloBloqueAgregado event) -> {
      if(!categoria.bloque().identity().equals(event.getBloqueId()))
        throw new IllegalArgumentException("El bloque no coincide con el de la categoria");
    categoria.bloque().AgregarPasillo(event.getPasillo());
    });

    apply((PasilloBloqueEliminado event) -> {
      if(!categoria.bloque().identity().equals(event.getBloqueId()))
        throw new IllegalArgumentException("El bloque no coincide con el de la categoria");
      categoria.bloque().EliminarPasillo(event.getPasillo());
      });

    apply((CantidadEstanteriasBloqueModificada event) -> {
      if(!categoria.bloque().identity().equals(event.getBloqueId()))
        throw new IllegalArgumentException("El bloque no coincide con el de la categoria");
      categoria.bloque().modificarCantidadEstanterias(event.getCantidadEstanterias());
    });
  }
}
