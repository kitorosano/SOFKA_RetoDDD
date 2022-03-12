package uy.com.sofka.biblioteca.boleta.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.boleta.value.Necesidad;
import uy.com.sofka.biblioteca.boleta.value.BoletaId;

public class ModificarNecesidad extends Command {
  private final BoletaId boletaId;
  private final Necesidad necesidad;

  public ModificarNecesidad(BoletaId boletaId, Necesidad necesidad) {
    this.boletaId = boletaId;
    this.necesidad = necesidad;
  }

  public BoletaId getBoletaId() {
    return this.boletaId;
  }

  public Necesidad getNecesidad() {
    return this.necesidad;
  }
}
