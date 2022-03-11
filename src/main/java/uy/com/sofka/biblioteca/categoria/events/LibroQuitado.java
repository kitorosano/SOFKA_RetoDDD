package uy.com.sofka.biblioteca.categoria.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.categoria.value.LibroId;

public class LibroQuitado extends DomainEvent{
  private final LibroId libroId;

  public LibroQuitado(LibroId libroId) {
    super("sofka.categoria.quitarlibro");
    this.libroId = libroId;
  } 

  public LibroId getLibroId() {
    return libroId;
  }
}
