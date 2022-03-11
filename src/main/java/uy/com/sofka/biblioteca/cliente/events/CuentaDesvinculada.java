package uy.com.sofka.biblioteca.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.cliente.value.CuentaId;

public class CuentaDesvinculada extends DomainEvent{
  private final CuentaId cuentaId;

  public CuentaDesvinculada(CuentaId cuentaId) {
    super("sofka.cliente.desvincularcuenta");
    this.cuentaId = cuentaId;
  } 

  public CuentaId getCuentaId() {
    return cuentaId;
  }
}
