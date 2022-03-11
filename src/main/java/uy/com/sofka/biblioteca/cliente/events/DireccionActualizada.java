package uy.com.sofka.biblioteca.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.cliente.value.Direccion;

public class DireccionActualizada extends DomainEvent {
  private final Direccion direccion;

  public DireccionActualizada(Direccion direccion) {
    super("sofka.cliente.actualizardireccion");
    this.direccion = direccion;
  }

  public Direccion getDireccion() {
    return direccion;
  }
  
}
