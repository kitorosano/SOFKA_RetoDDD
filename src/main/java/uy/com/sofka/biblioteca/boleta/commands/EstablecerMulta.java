package uy.com.sofka.biblioteca.boleta.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.boleta.value.BoletaId;
import uy.com.sofka.biblioteca.boleta.value.MontoMulta;
import uy.com.sofka.biblioteca.boleta.value.MultaId;
import uy.com.sofka.biblioteca.boleta.value.CondicionesMulta;

public class EstablecerMulta extends Command {
  private final BoletaId boletaId;
  private final MultaId multaId;
  private final CondicionesMulta condiciones;
  private final MontoMulta monto;
  
  public EstablecerMulta(BoletaId boletaId, MultaId multaId, CondicionesMulta condiciones, MontoMulta monto) {
    this.boletaId = boletaId;
    this.multaId = multaId;
    this.condiciones = condiciones;
    this.monto = monto;
  }

  public BoletaId getBoletaId() {
    return this.boletaId;
  }

  public MultaId getMultaId() {
    return this.multaId;
  }

  public CondicionesMulta getCondiciones() {
    return this.condiciones;
  }

  public MontoMulta getMontoMulta() {
    return this.monto;
  }
}
