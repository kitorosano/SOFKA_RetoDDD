package uy.com.sofka.biblioteca.cliente.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.value.ClienteId;
import uy.com.sofka.biblioteca.value.DireccionCliente;

public class ModificarDireccion extends Command {
  
  private final ClienteId clienteId;
  private final DireccionCliente direccion;

  public ModificarDireccion(ClienteId clienteId, DireccionCliente direccion) {
    this.clienteId = clienteId;
    this.direccion = direccion;
  }

  public ClienteId getClienteId() {
    return this.clienteId;
  }

  public DireccionCliente getDireccion() {
    return this.direccion;
  }
}
