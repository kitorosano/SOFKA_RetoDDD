package uy.com.sofka.biblioteca.boleta.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.boleta.value.BoletaId;
import uy.com.sofka.biblioteca.boleta.value.Fecha;
import uy.com.sofka.biblioteca.boleta.value.FechaDevolucion;
import uy.com.sofka.biblioteca.boleta.value.Necesidad;

public class CrearBoleta extends Command {
  private final BoletaId boletaId;
  private final Necesidad necesidad;
  private final Fecha fecha;
  private final FechaDevolucion fechaDevolucion;

  public CrearBoleta(BoletaId boletaId, Necesidad necesidad, Fecha fecha, FechaDevolucion fechaDevolucion) {
    this.boletaId = boletaId;
    this.necesidad = necesidad;
    this.fecha = fecha;
    this.fechaDevolucion = fechaDevolucion;
  }

  public BoletaId getBoletaId() {
    return this.boletaId;
  }

  public Necesidad getNecesidad() {
    return this.necesidad;
  }

  public Fecha getFecha() {
    return fecha;
  }

  public FechaDevolucion getFechaDevolucion() {
    return fechaDevolucion;
  }
}
