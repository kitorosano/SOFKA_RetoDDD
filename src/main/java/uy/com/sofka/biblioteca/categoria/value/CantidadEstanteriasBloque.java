package uy.com.sofka.biblioteca.categoria.value;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class CantidadEstanteriasBloque implements ValueObject<Integer> {
  private final Integer value;

  public CantidadEstanteriasBloque(Integer value) {
    this.value = Objects.requireNonNull(value);

    if(this.value < 0)
      throw new IllegalArgumentException("La cantidad de estanterias de bloque no puede ser negativa.");
  }

  @Override
  public Integer value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof CantidadEstanteriasBloque)) {
      return false;
    }
    CantidadEstanteriasBloque cantidadEstanteriasBloque = (CantidadEstanteriasBloque) o;
    return Objects.equals(value, cantidadEstanteriasBloque.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
  
}
