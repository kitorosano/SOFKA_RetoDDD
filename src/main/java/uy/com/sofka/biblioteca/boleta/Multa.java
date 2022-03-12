package uy.com.sofka.biblioteca.boleta;

import java.util.Objects;

import co.com.sofka.domain.generic.Entity;
import uy.com.sofka.biblioteca.boleta.value.CondicionesMulta;
import uy.com.sofka.biblioteca.boleta.value.MultaId;
import uy.com.sofka.biblioteca.boleta.value.MontoMulta;

public class Multa extends Entity<MultaId> {
  protected CondicionesMulta condiciones;
  protected MontoMulta monto;

  public Multa(MultaId multaId, CondicionesMulta condiciones, MontoMulta monto) {
    super(multaId);
    this.condiciones = condiciones;
    this.monto = monto;
  }

  // metodos (setters)
  public void modificarCondiciones(CondicionesMulta condiciones) {
    this.condiciones = Objects.requireNonNull(condiciones);
  }
  
  public void modificarMonto(MontoMulta monto) {
    this.monto = Objects.requireNonNull(monto);
  }
  
  //Getters
  public CondicionesMulta condiciones() {
    return condiciones;
  }

  public MontoMulta monto() {
    return monto;
  }
  
}
