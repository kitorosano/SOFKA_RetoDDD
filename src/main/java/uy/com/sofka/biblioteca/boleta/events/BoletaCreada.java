package uy.com.sofka.biblioteca.boleta.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.boleta.value.*;

public class BoletaCreada extends DomainEvent {
  private final Necesidad necesidad;
  private final Fecha fecha;
  private final FechaDevolucion fechaDevolucion;

  public BoletaCreada(Necesidad necesidad, Fecha fecha, FechaDevolucion fechaDevolucion) {
    super("sofka.boleta.boletacreada");
    this.necesidad = necesidad;
    this.fecha = fecha;
    this.fechaDevolucion = fechaDevolucion;
  }
  
  public Necesidad getNecesidad() {
    return necesidad;
  }

  public Fecha getFecha() {
    return fecha;
  }

  public FechaDevolucion getFechaDevolucion() {
    return fechaDevolucion;
  }
}
