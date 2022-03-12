package uy.com.sofka.biblioteca.boleta.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.boleta.value.FechaDevolucion;

public class FechaDevolucionModificada extends DomainEvent {
  private final FechaDevolucion fechaDevolucion;

  public FechaDevolucionModificada(FechaDevolucion fechaDevolucion) {
    super("sofka.boleta.modificarfechavevolucion");
    this.fechaDevolucion = fechaDevolucion;
  }

  public FechaDevolucion getFechaDevolucion() {
    return fechaDevolucion;
  }
  
}
