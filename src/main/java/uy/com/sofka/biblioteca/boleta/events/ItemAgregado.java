package uy.com.sofka.biblioteca.boleta.events;

import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.boleta.value.CantidadItem;
import uy.com.sofka.biblioteca.boleta.value.ItemId;
import uy.com.sofka.biblioteca.categoria.value.CategoriaId;
import uy.com.sofka.biblioteca.categoria.value.LibroId;

public class ItemAgregado extends DomainEvent{
  private final ItemId itemId;
  private final LibroId libroId;
  private final CategoriaId categoriaId;
  private final CantidadItem cantidad;

  public ItemAgregado(ItemId itemId, LibroId libroId, CategoriaId categoriaId, CantidadItem cantidad) {
    super("sofka.boleta.agregaritem");
    this.itemId = itemId;
    this.libroId = libroId;
    this.categoriaId = categoriaId;
    this.cantidad = cantidad;
  }

  public ItemId getItemId() {
    return itemId;
  }

  public LibroId getLibroId() {
    return libroId;
  }

  public LibroId getEditorialId() {
    return libroId;
  }

  public CategoriaId getCategoriaId() {
    return categoriaId;
  }

  public CantidadItem getCantidad() {
    return cantidad;
  }
}
