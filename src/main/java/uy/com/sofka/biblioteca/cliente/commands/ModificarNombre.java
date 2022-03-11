package uy.com.sofka.biblioteca.cliente.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.cliente.value.Nombre;
import uy.com.sofka.biblioteca.cliente.value.ClienteId;

public class ModificarNombre extends Command {
  private final ClienteId clienteId;
  private final Nombre nombre;

  public ModificarNombre(ClienteId clienteId, Nombre nombre) {
    this.clienteId = clienteId;
    this.nombre = nombre;
  }

  public ClienteId getClienteId() {
    return this.clienteId;
  }

  public Nombre getNombre() {
    return this.nombre;
  }
}
