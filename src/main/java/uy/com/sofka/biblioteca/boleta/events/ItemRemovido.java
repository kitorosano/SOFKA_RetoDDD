package uy.com.sofka.biblioteca.boleta.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.boleta.value.ItemId;

public class ItemRemovido extends DomainEvent{
  private final ItemId itemId;

  public ItemRemovido(ItemId itemId) {
    super("sofka.boleta.removeritem");
    this.itemId = itemId;
  } 

  public ItemId getItemId() {
    return itemId;
  }
}
