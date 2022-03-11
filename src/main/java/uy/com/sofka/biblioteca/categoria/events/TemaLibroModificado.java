package uy.com.sofka.biblioteca.categoria.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.categoria.value.LibroId;
import uy.com.sofka.biblioteca.categoria.value.TemaLibro;

public class TemaLibroModificado extends DomainEvent{
  private final LibroId libroId;
  private final TemaLibro tema;

  public TemaLibroModificado(LibroId libroId, TemaLibro tema) {
    super("sofka.categoria.modificartemalibro");
    this.libroId = libroId;
    this.tema = tema;
  } 

  public LibroId getLibroId() {
    return libroId;
  }
  public TemaLibro getTema() {
    return tema;
  }
}
