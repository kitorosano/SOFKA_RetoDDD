package uy.com.sofka.biblioteca.cliente.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.cliente.value.CuentaId;
import uy.com.sofka.biblioteca.value.ClienteId;
import uy.com.sofka.biblioteca.cliente.value.NombreUsuarioCuenta;
import uy.com.sofka.biblioteca.cliente.value.ProveedorCuenta;
import uy.com.sofka.biblioteca.cliente.value.CorreoCuenta;

public class VincularCuenta extends Command {
  private final ClienteId clienteId;
  private final CuentaId cuentaId;
  private final NombreUsuarioCuenta nombreUsuario;
  private final CorreoCuenta correo;
  private final ProveedorCuenta proveedor;

  public VincularCuenta(ClienteId clienteId, CuentaId cuentaId, NombreUsuarioCuenta nombreUsuario, CorreoCuenta correo, ProveedorCuenta proveedor) {
    this.clienteId = clienteId;
    this.cuentaId = cuentaId;
    this.nombreUsuario = nombreUsuario;
    this.correo = correo;
    this.proveedor = proveedor;
  }

  public ClienteId getClienteId() {
    return this.clienteId;
  }

  public CuentaId getCuentaId() {
    return this.cuentaId;
  }

  public NombreUsuarioCuenta getNombreUsuario() {
    return this.nombreUsuario;
  }

  public CorreoCuenta getTelefono() {
    return this.correo;
  }

  public ProveedorCuenta getProveedor() {
    return proveedor;
  }

}
