package uy.com.sofka.biblioteca.boleta.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.boleta.value.BoletaId;
import uy.com.sofka.biblioteca.value.*;

public class AsignarCliente extends Command {
  private final BoletaId boletaId;
  private final ClienteId clienteId;
  private final NombreCliente nombre;
  private final DireccionCliente direccion;
  private final TelefonoCliente telefono;
  private final CedulaCliente cedula;
  
  public AsignarCliente(BoletaId boletaId, ClienteId clienteId, NombreCliente nombre, DireccionCliente direccion, TelefonoCliente telefono, CedulaCliente cedula) {
    this.boletaId = boletaId;
    this.clienteId = clienteId;
    this.nombre = nombre;
    this.direccion = direccion;
    this.telefono = telefono;
    this.cedula = cedula;
  }

  public BoletaId getBoletaId() {
    return this.boletaId;
  }

  public ClienteId getClienteId() {
    return this.clienteId;
  }

  public NombreCliente getNombre() {
    return this.nombre;
  }

  public DireccionCliente getDireccion() {
    return this.direccion;
  }

  public TelefonoCliente getTelefono() {
    return telefono;
  }

  public CedulaCliente getCedula() {
    return cedula;
  }
}
