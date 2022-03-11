package uy.com.sofka.biblioteca.categoria.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.categoria.value.LibroId;
import uy.com.sofka.biblioteca.categoria.value.TituloLibro;

public class TituloLibroModificado extends DomainEvent{
  private final LibroId libroId;
  private final TituloLibro titulo;

  public TituloLibroModificado(LibroId libroId, TituloLibro titulo) {
    super("sofka.categoria.modificartitulolibro");
    this.libroId = libroId;
    this.titulo = titulo;
  } 

  public LibroId getLibroId() {
    return libroId;
  }
  public TituloLibro getTitulo() {
    return titulo;
  }
}
