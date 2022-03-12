package uy.com.sofka.biblioteca.boleta.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.boleta.value.ItemId;
import uy.com.sofka.biblioteca.boleta.value.BoletaId;
import uy.com.sofka.biblioteca.boleta.value.CantidadItem;

public class ModificarCantidadItem extends Command {
  
  private final BoletaId boletaId;
  private final ItemId itemId;
  private final CantidadItem cantidad;

  public ModificarCantidadItem(BoletaId boletaId, ItemId itemId, CantidadItem cantidad) {
    this.boletaId = boletaId;
    this.itemId = itemId;
    this.cantidad = cantidad;
  }

  public BoletaId getBoletaId() {
    return this.boletaId;
  }

  public ItemId getItemId() {
    return this.itemId;
  }

  public CantidadItem getCantidad() {
    return this.cantidad;
  }
}
