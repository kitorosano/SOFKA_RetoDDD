package uy.com.sofka.biblioteca.boleta.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.boleta.value.BoletaId;
import uy.com.sofka.biblioteca.value.ClienteId;
import uy.com.sofka.biblioteca.value.TelefonoCliente;

public class ModificarTelefonoCliente extends Command {
  private final BoletaId boletaId;
  private final ClienteId clienteId; 
  private final TelefonoCliente telefono;

  public ModificarTelefonoCliente(BoletaId boletaId, ClienteId clienteId, TelefonoCliente telefono) {
    this.boletaId = boletaId;
    this.clienteId = clienteId;
    this.telefono = telefono;
  }
  
  public BoletaId getBoletaId() {
    return this.boletaId;
  }

  public ClienteId getClienteId() {
    return this.clienteId;
  }

  public TelefonoCliente getTelefono() {
    return this.telefono;
  }
}
