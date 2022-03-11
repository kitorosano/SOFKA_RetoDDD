package uy.com.sofka.biblioteca.categoria.commands;

import co.com.sofka.domain.generic.Command;
import uy.com.sofka.biblioteca.categoria.value.CategoriaId;
import uy.com.sofka.biblioteca.categoria.value.BloqueId;
import uy.com.sofka.biblioteca.categoria.value.PasilloBloque;

public class AgregarPasilloBloque extends Command {
  private final CategoriaId categoriaId;
  private final BloqueId bloqueId; 
  private final PasilloBloque pasillo;

  public AgregarPasilloBloque(CategoriaId categoriaId, BloqueId bloqueId, PasilloBloque pasillo) {
    this.categoriaId = categoriaId;
    this.bloqueId = bloqueId;
    this.pasillo = pasillo;
  }
  
  public CategoriaId getCategoriaId() {
    return this.categoriaId;
  }

  public BloqueId getBloqueId() {
    return this.bloqueId;
  }

  public PasilloBloque getPasilloBloque() {
    return this.pasillo;
  }
}
