package uy.com.sofka.biblioteca.cliente.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.cliente.value.ClienteId;
import uy.com.sofka.biblioteca.cliente.value.Direccion;

public class ActualizarDireccion extends Command {
  
  private final ClienteId clienteId;
  private final Direccion direccion;

  public ActualizarDireccion(ClienteId clienteId, Direccion direccion) {
    this.clienteId = clienteId;
    this.direccion = direccion;
  }

  public ClienteId getClienteId() {
    return this.clienteId;
  }

  public Direccion getDireccion() {
    return this.direccion;
  }
}
