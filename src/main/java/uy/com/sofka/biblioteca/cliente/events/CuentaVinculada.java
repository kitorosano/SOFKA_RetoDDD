package uy.com.sofka.biblioteca.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.cliente.value.CorreoCuenta;
import uy.com.sofka.biblioteca.cliente.value.CuentaId;
import uy.com.sofka.biblioteca.cliente.value.ProveedorCuenta;
import uy.com.sofka.biblioteca.cliente.value.NombreUsuarioCuenta;

public class CuentaVinculada extends DomainEvent{
  private final CuentaId cuentaId;
  private final NombreUsuarioCuenta nombreUsuario;
  private final CorreoCuenta correo;
  private final ProveedorCuenta proveedor;

  public CuentaVinculada(CuentaId cuentaId, NombreUsuarioCuenta nombreUsuario, CorreoCuenta correo, ProveedorCuenta proveedor) {
    super("sofka.cliente.vincularcuenta");
    this.cuentaId = cuentaId;
    this.nombreUsuario = nombreUsuario;
    this.correo = correo;
    this.proveedor = proveedor;
  } 

  public CuentaId getCuentaId() {
    return cuentaId;
  }

  public NombreUsuarioCuenta getNombreUsuarioCuenta() {
    return nombreUsuario;
  }

  public CorreoCuenta getCorreoCuenta() {
    return correo;
  }

  public ProveedorCuenta getProveedorCuenta() {
    return proveedor;
  }
}
