package uy.com.sofka.biblioteca.boleta.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.value.ClienteId;
import uy.com.sofka.biblioteca.value.NombreCliente;

public class NombreClienteModificado extends DomainEvent {
  private final ClienteId clienteId; 
  private final NombreCliente nombre;

  public NombreClienteModificado(ClienteId clienteId, NombreCliente nombre) {
    super("sofka.boleta.modificarnombrecliente");
    this.clienteId = clienteId;
    this.nombre = nombre;
  }

  public ClienteId getClienteId() {
    return clienteId;
  }

  public NombreCliente getNombre() {
    return nombre;
  }
  
}
