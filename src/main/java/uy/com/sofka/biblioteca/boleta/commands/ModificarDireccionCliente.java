package uy.com.sofka.biblioteca.boleta.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.boleta.value.BoletaId;
import uy.com.sofka.biblioteca.value.ClienteId;
import uy.com.sofka.biblioteca.value.DireccionCliente;

public class ModificarDireccionCliente extends Command {
  private final BoletaId boletaId;
  private final ClienteId clienteId; 
  private final DireccionCliente direccion;

  public ModificarDireccionCliente(BoletaId boletaId, ClienteId clienteId, DireccionCliente direccion) {
    this.boletaId = boletaId;
    this.clienteId = clienteId;
    this.direccion = direccion;
  }
  
  public BoletaId getBoletaId() {
    return this.boletaId;
  }

  public ClienteId getClienteId() {
    return this.clienteId;
  }

  public DireccionCliente getDireccion() {
    return this.direccion;
  }
}
