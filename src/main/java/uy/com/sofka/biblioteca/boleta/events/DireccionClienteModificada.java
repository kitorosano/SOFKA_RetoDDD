package uy.com.sofka.biblioteca.boleta.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.value.ClienteId;
import uy.com.sofka.biblioteca.value.DireccionCliente;

public class DireccionClienteModificada extends DomainEvent {
  private final ClienteId clienteId; 
  private final DireccionCliente direccion;

  public DireccionClienteModificada(ClienteId clienteId, DireccionCliente direccion) {
    super("sofka.boleta.modificardireccioncliente");
    this.clienteId = clienteId;
    this.direccion = direccion;
  }

  public ClienteId getClienteId() {
    return clienteId;
  }

  public DireccionCliente getDireccion() {
    return direccion;
  }
  
}
