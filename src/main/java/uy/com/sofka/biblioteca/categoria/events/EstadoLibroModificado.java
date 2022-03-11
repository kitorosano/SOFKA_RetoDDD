package uy.com.sofka.biblioteca.categoria.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.categoria.value.LibroId;
import uy.com.sofka.biblioteca.categoria.value.EstadoLibro;

public class EstadoLibroModificado extends DomainEvent{
  private final LibroId libroId;
  private final EstadoLibro estado;

  public EstadoLibroModificado(LibroId libroId, EstadoLibro estado) {
    super("sofka.categoria.modificarestadolibro");
    this.libroId = libroId;
    this.estado = estado;
  } 

  public LibroId getLibroId() {
    return libroId;
  }
  public EstadoLibro getEstado() {
    return estado;
  }
}
