package uy.com.sofka.biblioteca.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.value.DireccionCliente;

public class DireccionModificada extends DomainEvent {
  private final DireccionCliente direccion;

  public DireccionModificada(DireccionCliente direccion) {
    super("sofka.cliente.modificardireccion");
    this.direccion = direccion;
  }

  public DireccionCliente getDireccion() {
    return direccion;
  }
  
}
