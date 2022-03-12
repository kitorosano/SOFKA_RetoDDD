package uy.com.sofka.biblioteca.boleta;

import java.util.Objects;

import co.com.sofka.domain.generic.Entity;
import uy.com.sofka.biblioteca.boleta.value.ItemId;
import uy.com.sofka.biblioteca.categoria.value.CategoriaId;
import uy.com.sofka.biblioteca.categoria.value.LibroId;
import uy.com.sofka.biblioteca.boleta.value.CantidadItem;

public class Item extends Entity<ItemId> {
  protected LibroId libroId;
  protected CategoriaId categoriaId;
  protected CantidadItem cantidad;

  public Item(ItemId itemId, LibroId libroId, CategoriaId categoriaId, CantidadItem cantidad) {
    super(itemId);
    this.libroId = libroId;
    this.categoriaId = categoriaId;
    this.cantidad = cantidad;
  }

  // metodos (setters)
  public void modificarCantidad(CantidadItem cantidad) {
    this.cantidad = Objects.requireNonNull(cantidad);
  }
  
  //Getters
  public LibroId libroId() {
    return libroId;
  }

  public CategoriaId categoriaId() {
    return categoriaId;
  }

  public CantidadItem cantidad() {
    return cantidad;
  }
  
}
