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
  private final CantidadItem titulo;

  public AgregarItem(BoletaId boletaId, ItemId itemId, CategoriaId categoriaId, LibroId libroId, CantidadItem titulo) {
    this.boletaId = boletaId;
    this.itemId = itemId;
    this.categoriaId = categoriaId;
    this.libroId = libroId;
    this.titulo = titulo;
  }

  public BoletaId getBoletaId() {
    return this.boletaId;
  }

  public ItemId getItemId() {
    return this.itemId;
  }

  public CategoriaId getEditorialId() {
    return this.categoriaId;
  }

  public LibroId getLibroId() {
    return this.libroId;
  }

  public CantidadItem getCantidad() {
    return this.titulo;
  }

}
