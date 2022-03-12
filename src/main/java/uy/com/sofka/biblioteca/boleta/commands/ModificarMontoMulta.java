package uy.com.sofka.biblioteca.boleta.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.boleta.value.BoletaId;
import uy.com.sofka.biblioteca.boleta.value.MultaId;
import uy.com.sofka.biblioteca.boleta.value.MontoMulta;

public class ModificarMontoMulta extends Command {
  private final BoletaId boletaId;
  private final MultaId multaId; 
  private final MontoMulta monto;

  public ModificarMontoMulta(BoletaId boletaId, MultaId multaId, MontoMulta monto) {
    this.boletaId = boletaId;
    this.multaId = multaId;
    this.monto = monto;
  }
  
  public BoletaId getBoletaId() {
    return this.boletaId;
  }

  public MultaId getMultaId() {
    return this.multaId;
  }

  public MontoMulta getMontoMulta() {
    return this.monto;
  }
}
