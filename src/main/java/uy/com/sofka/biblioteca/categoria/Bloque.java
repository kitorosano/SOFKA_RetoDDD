package uy.com.sofka.biblioteca.categoria;

import java.util.Objects;
import java.util.Set;

import co.com.sofka.domain.generic.Entity;
import uy.com.sofka.biblioteca.categoria.value.DescripcionBloque;
import uy.com.sofka.biblioteca.categoria.value.PasilloBloque;
import uy.com.sofka.biblioteca.categoria.value.BloqueId;
import uy.com.sofka.biblioteca.categoria.value.CantidadEstanteriasBloque;

public class Bloque extends Entity<BloqueId> {
  protected DescripcionBloque descripcion;
  protected Set<PasilloBloque> pasillos;
  protected CantidadEstanteriasBloque cantidadEstanterias;

  public Bloque(BloqueId bloqueId, DescripcionBloque descripcion, Set<PasilloBloque> pasillos, CantidadEstanteriasBloque cantidadEstanterias) {
    super(bloqueId);
    this.descripcion = descripcion;
    this.pasillos = pasillos;
    this.cantidadEstanterias = cantidadEstanterias;
  }

  // metodos (setters)
  public void modificarDescripcion(DescripcionBloque descripcion) {
    this.descripcion = Objects.requireNonNull(descripcion);
  }

  public void AgregarPasillo(PasilloBloque pasillo) {
    this.pasillos.add(Objects.requireNonNull(pasillo));
  }
  
  public void EliminarPasillo(PasilloBloque pasillo) {
    this.pasillos.remove(Objects.requireNonNull(pasillo));
  }
  
  public void modificarCantidadEstanterias(CantidadEstanteriasBloque cantidadEstanterias) {
    this.cantidadEstanterias = Objects.requireNonNull(cantidadEstanterias);
  }
  
  //Getters
  public DescripcionBloque descripcion() {
    return descripcion;
  }
  
  public Set<PasilloBloque> pasillos() {
    return pasillos;
  }

  public CantidadEstanteriasBloque cantidadEstanterias() {
    return cantidadEstanterias;
  }
  
}
