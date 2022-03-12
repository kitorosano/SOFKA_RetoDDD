package uy.com.sofka.biblioteca.cliente.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.value.*;

public class CrearCliente extends Command {
  private final ClienteId clienteId;
  private final NombreCliente nombre;
  private final DireccionCliente direccion;
  private final TelefonoCliente telefono;
  private final CedulaCliente cedula;

  public CrearCliente(ClienteId clienteId, NombreCliente nombre, DireccionCliente direccion, TelefonoCliente telefono, CedulaCliente cedula) {
    this.clienteId = clienteId;
    this.nombre = nombre;
    this.direccion = direccion;
    this.telefono = telefono;
    this.cedula = cedula;
  }

  public ClienteId getClienteId() {
    return this.clienteId;
  }

  public NombreCliente getNombre() {
    return this.nombre;
  }

  public DireccionCliente getDireccion() {
    return direccion;
  }

  public TelefonoCliente getTelefono() {
    return this.telefono;
  }

  public CedulaCliente getCedula() {
    return cedula;
  }

}
