package uy.com.sofka.biblioteca.categoria.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.categoria.value.LibroId;
import uy.com.sofka.biblioteca.categoria.value.AcotacionLibro;

public class AcotacionLibroModificada extends DomainEvent{
  private final LibroId libroId;
  private final AcotacionLibro acotacion;

  public AcotacionLibroModificada(LibroId libroId, AcotacionLibro acotacion) {
    super("sofka.categoria.modificaracotacionlibro");
    this.libroId = libroId;
    this.acotacion = acotacion;
  } 

  public LibroId getLibroId() {
    return libroId;
  }
  public AcotacionLibro getAcotacion() {
    return acotacion;
  }
}
