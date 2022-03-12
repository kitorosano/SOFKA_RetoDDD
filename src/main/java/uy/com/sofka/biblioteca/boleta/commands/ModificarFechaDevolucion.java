package uy.com.sofka.biblioteca.boleta.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.boleta.value.FechaDevolucion;
import uy.com.sofka.biblioteca.boleta.value.BoletaId;

public class ModificarFechaDevolucion extends Command {
  private final BoletaId boletaId;
  private final FechaDevolucion fechaDevolucion;

  public ModificarFechaDevolucion(BoletaId boletaId, FechaDevolucion fechaDevolucion) {
    this.boletaId = boletaId;
    this.fechaDevolucion = fechaDevolucion;
  }

  public BoletaId getBoletaId() {
    return this.boletaId;
  }

  public FechaDevolucion getFechaDevolucion() {
    return this.fechaDevolucion;
  }
}
