package uy.com.sofka.biblioteca.cliente.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.cliente.value.CuentaId;
import uy.com.sofka.biblioteca.cliente.value.ClienteId;
import uy.com.sofka.biblioteca.cliente.value.NombreUsuarioCuenta;

public class ModificarNombreUsuarioCuenta extends Command {
  
  private final ClienteId clienteId;
  private final CuentaId cuentaId;
  private final NombreUsuarioCuenta nombreUsuario;

  public ModificarNombreUsuarioCuenta(ClienteId clienteId, CuentaId cuentaId, NombreUsuarioCuenta nombreUsuario) {
    this.clienteId = clienteId;
    this.cuentaId = cuentaId;
    this.nombreUsuario = nombreUsuario;
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
}
