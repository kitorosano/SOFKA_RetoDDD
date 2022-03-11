package uy.com.sofka.biblioteca.cliente.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.cliente.value.ClienteId;
import uy.com.sofka.biblioteca.cliente.value.Telefono;
import uy.com.sofka.biblioteca.cliente.value.Nombre;

public class CrearCliente extends Command {
  private final ClienteId clienteId;
  private final Nombre nombre;
  private final Telefono telefono;

  public CrearCliente(ClienteId clienteId, Nombre nombre, Telefono telefono) {
    this.clienteId = clienteId;
    this.nombre = nombre;
    this.telefono = telefono;
  }

  public ClienteId getClienteId() {
    return this.clienteId;
  }

  public Nombre getNombre() {
    return this.nombre;
  }

  public Telefono getTelefono() {
    return this.telefono;
  }

}
