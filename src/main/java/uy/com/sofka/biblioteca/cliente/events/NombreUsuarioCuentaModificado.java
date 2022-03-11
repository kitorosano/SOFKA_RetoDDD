package uy.com.sofka.biblioteca.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.cliente.value.CuentaId;
import uy.com.sofka.biblioteca.cliente.value.NombreUsuarioCuenta;

public class NombreUsuarioCuentaModificado extends DomainEvent{
  private final CuentaId cuentaId;
  private final NombreUsuarioCuenta nombreUsuario;

  public NombreUsuarioCuentaModificado(CuentaId cuentaId, NombreUsuarioCuenta nombreUsuario) {
    super("sofka.cliente.modificarnombreusuariocuenta");
    this.cuentaId = cuentaId;
    this.nombreUsuario = nombreUsuario;
  } 

  public CuentaId getCuentaId() {
    return cuentaId;
  }
  public NombreUsuarioCuenta getNombreUsuario() {
    return nombreUsuario;
  }
}
