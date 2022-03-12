package uy.com.sofka.biblioteca.cliente.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.value.NombreCliente;
import uy.com.sofka.biblioteca.value.ClienteId;

public class ModificarNombre extends Command {
  private final ClienteId clienteId;
  private final NombreCliente nombre;

  public ModificarNombre(ClienteId clienteId, NombreCliente nombre) {
    this.clienteId = clienteId;
    this.nombre = nombre;
  }

  public ClienteId getClienteId() {
    return this.clienteId;
  }

  public NombreCliente getNombre() {
    return this.nombre;
  }
}
