package uy.com.sofka.biblioteca.boleta.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.boleta.value.BoletaId;
import uy.com.sofka.biblioteca.boleta.value.ItemId;

public class RemoverItem extends Command {
  private final BoletaId boletaId;
  private final ItemId itemId;

  public RemoverItem(BoletaId boletaId, ItemId itemId) {
    this.boletaId = boletaId;
    this.itemId = itemId;
  }

  public BoletaId getBoletaId() {
    return this.boletaId;
  }

  public ItemId getItemId() {
    return this.itemId;
  }
}
