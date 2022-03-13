package uy.com.sofka.biblioteca.boleta.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.boleta.value.BoletaId;
import uy.com.sofka.biblioteca.boleta.value.CantidadItem;
import uy.com.sofka.biblioteca.boleta.value.ItemId;
import uy.com.sofka.biblioteca.categoria.value.CategoriaId;
import uy.com.sofka.biblioteca.categoria.value.LibroId;

public class AgregarItem extends Command {
  private final BoletaId boletaId;
  private final ItemId itemId;
  private final CategoriaId categoriaId;
  private final LibroId libroId;
  private final CantidadItem cantidad;

  public AgregarItem(BoletaId boletaId, ItemId itemId, CategoriaId categoriaId, LibroId libroId, CantidadItem cantidad) {
    this.boletaId = boletaId;
    this.itemId = itemId;
    this.categoriaId = categoriaId;
    this.libroId = libroId;
    this.cantidad = cantidad;
  }

  public BoletaId getBoletaId() {
    return this.boletaId;
  }

  public ItemId getItemId() {
    return this.itemId;
  }

  public CategoriaId getCategoriaId() {
    return this.categoriaId;
  }

  public LibroId getLibroId() {
    return this.libroId;
  }

  public CantidadItem getCantidad() {
    return this.cantidad;
  }

}
