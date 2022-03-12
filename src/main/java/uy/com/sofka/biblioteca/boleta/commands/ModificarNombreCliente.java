package uy.com.sofka.biblioteca.boleta.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.boleta.value.BoletaId;
import uy.com.sofka.biblioteca.value.ClienteId;
import uy.com.sofka.biblioteca.value.NombreCliente;

public class ModificarNombreCliente extends Command {
  private final BoletaId boletaId;
  private final ClienteId clienteId; 
  private final NombreCliente nombre;

  public ModificarNombreCliente(BoletaId boletaId, ClienteId clienteId, NombreCliente nombre) {
    this.boletaId = boletaId;
    this.clienteId = clienteId;
    this.nombre = nombre;
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
}
