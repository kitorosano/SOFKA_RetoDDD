package uy.com.sofka.biblioteca.boleta.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.boleta.value.ItemId;
import uy.com.sofka.biblioteca.boleta.value.CantidadItem;

public class CantidadItemModificado extends DomainEvent{
  private final ItemId itemId;
  private final CantidadItem cantidad;

  public CantidadItemModificado(ItemId itemId, CantidadItem cantidad) {
    super("sofka.boleta.modificarcantidaditem");
    this.itemId = itemId;
    this.cantidad = cantidad;
  } 

  public ItemId getItemId() {
    return itemId;
  }
  public CantidadItem getCantidad() {
    return cantidad;
  }
}
