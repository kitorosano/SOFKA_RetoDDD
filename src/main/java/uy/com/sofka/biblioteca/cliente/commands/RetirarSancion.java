package uy.com.sofka.biblioteca.cliente.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.value.ClienteId;
import uy.com.sofka.biblioteca.cliente.value.SancionId;

public class RetirarSancion extends Command {
  private final ClienteId clienteId;
  private final SancionId sancionId;

  public RetirarSancion(ClienteId clienteId, SancionId sancionId) {
    this.clienteId = clienteId;
    this.sancionId = sancionId;
  }

  public ClienteId getClienteId() {
    return this.clienteId;
  }

  public SancionId getSancionId() {
    return this.sancionId;
  }
}
