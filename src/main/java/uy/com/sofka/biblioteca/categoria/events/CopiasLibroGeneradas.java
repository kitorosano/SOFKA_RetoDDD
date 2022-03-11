package uy.com.sofka.biblioteca.categoria.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.categoria.value.CopiasLibro;
import uy.com.sofka.biblioteca.categoria.value.LibroId;

public class CopiasLibroGeneradas extends DomainEvent{
  private final LibroId libroId;
  private final CopiasLibro copias;

  public CopiasLibroGeneradas(LibroId libroId, CopiasLibro copias) {
    super("sofka.categoria.generarcopiaslibro");
    this.libroId = libroId;
    this.copias = copias;
  } 

  public LibroId getLibroId() {
    return libroId;
  }
  public CopiasLibro getCopias() {
    return copias;
  }
}
