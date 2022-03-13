package uy.com.sofka.biblioteca.boleta;

import java.util.HashSet;

import co.com.sofka.domain.generic.EventChange;
import uy.com.sofka.biblioteca.boleta.events.*;

public class BoletaChange extends EventChange {
  
  public BoletaChange(Boleta boleta){

    apply((BoletaCreada event) -> {
      boleta.necesidad = event.getNecesidad();
      boleta.fecha = event.getFecha();
      boleta.fechaDevolucion = event.getFechaDevolucion();
      boleta.items = new HashSet<Item>();
    });
    
    apply((NecesidadModificada event) -> {
      boleta.necesidad = event.getNecesidad();
    });

    apply((FechaDevolucionModificada event) -> {
      boleta.fechaDevolucion = event.getFechaDevolucion();
    });

    apply((MultaEstablecida event) -> {
      boleta.multa = new Multa(
          event.getMultaId(),
          event.getCondiciones(),
          event.getMonto()
      );
    });

    apply((CondicionesMultaModificada event) -> {
      if(!boleta.multa().identity().equals(event.getMultaId()))
        throw new IllegalArgumentException("La multa no coincide con la de la boleta");
      boleta.multa().modificarCondiciones(event.getCondiciones());
    });

    apply((MontoMultaModificada event) -> {
      if(!boleta.multa().identity().equals(event.getMultaId()))
        throw new IllegalArgumentException("La multa no coincide con la de la boleta");
      boleta.multa().modificarMonto(event.getMonto());
    });
    
    apply((ClienteAsignado event) -> {
      boleta.cliente = new Cliente(
          event.getClienteId(),
          event.getNombre(),
          event.getDireccion(),
          event.getTelefono(),
          event.getCedula()
      );
    });

    apply((NombreClienteModificado event) -> {
      if(!boleta.cliente().identity().equals(event.getClienteId()))
        throw new IllegalArgumentException("El cliente no coincide con el de la boleta");
      boleta.cliente().modificarNombre(event.getNombre());
    });

    apply((DireccionClienteModificada event) -> {
      if(!boleta.cliente().identity().equals(event.getClienteId()))
        throw new IllegalArgumentException("El cliente no coincide con el de la boleta");
      boleta.cliente().modificarDireccion(event.getDireccion());
    });

    apply((TelefonoClienteModificado event) -> {
      if(!boleta.cliente().identity().equals(event.getClienteId()))
        throw new IllegalArgumentException("El cliente no coincide con el de la boleta");
      boleta.cliente().modificarTelefono(event.getTelefono());
    });

    apply((ItemAgregado event) -> {
      boleta.items.add(new Item(
          event.getItemId(),
          event.getLibroId(),
          event.getCategoriaId(),
          event.getCantidad()
      ));
    });

    apply((ItemRemovido event) -> {
      boleta.getItemPorId(event.getItemId())
          .orElseThrow(() -> new IllegalArgumentException("No se encuentra el item de la boleta"));
      boleta.items.removeIf(item -> item.identity().equals(event.getItemId()));
    });

    apply((CantidadItemModificado event) -> {
      var item = boleta.getItemPorId(event.getItemId())
              .orElseThrow(() -> new IllegalArgumentException("No se encuentra el item de la boleta"));
      item.modificarCantidad(event.getCantidad());
    });

  }
}
