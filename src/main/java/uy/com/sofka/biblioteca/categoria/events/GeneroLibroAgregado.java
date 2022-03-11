package uy.com.sofka.biblioteca.categoria.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.categoria.value.GeneroLibro;
import uy.com.sofka.biblioteca.categoria.value.LibroId;

public class GeneroLibroAgregado extends DomainEvent{
  private final LibroId libroId;
  private final GeneroLibro genero;

  public GeneroLibroAgregado(LibroId libroId, GeneroLibro genero) {
    super("sofka.categoria.agregargenerolibro");
    this.libroId = libroId;
    this.genero = genero;
  } 

  public LibroId getLibroId() {
    return libroId;
  }
  public GeneroLibro getGenero() {
    return genero;
  }
}
