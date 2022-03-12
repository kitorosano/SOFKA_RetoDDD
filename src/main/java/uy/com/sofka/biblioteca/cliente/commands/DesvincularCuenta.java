package uy.com.sofka.biblioteca.cliente.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.value.ClienteId;
import uy.com.sofka.biblioteca.cliente.value.CuentaId;

public class DesvincularCuenta extends Command {
  private final ClienteId clienteId;
  private final CuentaId cuentaId;

  public DesvincularCuenta(ClienteId clienteId, CuentaId cuentaId) {
    this.clienteId = clienteId;
    this.cuentaId = cuentaId;
  }

  public ClienteId getClienteId() {
    return this.clienteId;
  }

  public CuentaId getCuentaId() {
    return this.cuentaId;
  }
}
