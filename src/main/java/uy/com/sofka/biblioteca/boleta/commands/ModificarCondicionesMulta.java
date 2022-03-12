package uy.com.sofka.biblioteca.boleta.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.boleta.value.BoletaId;
import uy.com.sofka.biblioteca.boleta.value.MultaId;
import uy.com.sofka.biblioteca.boleta.value.CondicionesMulta;

public class ModificarCondicionesMulta extends Command {
  private final BoletaId boletaId;
  private final MultaId multaId; 
  private final CondicionesMulta condiciones;

  public ModificarCondicionesMulta(BoletaId boletaId, MultaId multaId, CondicionesMulta condiciones) {
    this.boletaId = boletaId;
    this.multaId = multaId;
    this.condiciones = condiciones;
  }
  
  public BoletaId getBoletaId() {
    return this.boletaId;
  }

  public MultaId getMultaId() {
    return this.multaId;
  }

  public CondicionesMulta getCondicionesMulta() {
    return this.condiciones;
  }
}
