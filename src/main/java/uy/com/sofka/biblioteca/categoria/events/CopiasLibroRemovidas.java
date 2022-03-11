package uy.com.sofka.biblioteca.categoria.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.categoria.value.CopiasLibro;
import uy.com.sofka.biblioteca.categoria.value.LibroId;

public class CopiasLibroRemovidas extends DomainEvent{
  private final LibroId libroId;
  private final CopiasLibro copias;

  public CopiasLibroRemovidas(LibroId libroId, CopiasLibro copias) {
    super("sofka.categoria.removercopiaslibro");
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
