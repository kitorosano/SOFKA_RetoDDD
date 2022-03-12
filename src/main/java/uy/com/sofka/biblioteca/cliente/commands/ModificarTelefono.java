package uy.com.sofka.biblioteca.cliente.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.value.ClienteId;
import uy.com.sofka.biblioteca.value.TelefonoCliente;

public class ModificarTelefono extends Command {
  
  private final ClienteId clienteId;
  private final TelefonoCliente telefono;

  public ModificarTelefono(ClienteId clienteId, TelefonoCliente telefono) {
    this.clienteId = clienteId;
    this.telefono = telefono;
  }

  public ClienteId getClienteId() {
    return this.clienteId;
  }

  public TelefonoCliente getTelefono() {
    return this.telefono;
  }
}
