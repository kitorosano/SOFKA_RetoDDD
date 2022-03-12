package uy.com.sofka.biblioteca.boleta.value;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class CantidadItem implements ValueObject<Integer> {
  private final Integer value;

  public CantidadItem(Integer value) {
    this.value = Objects.requireNonNull(value);

    if(this.value < 0)
      throw new IllegalArgumentException("La cantidad de items no puede ser negativa.");
  }

  @Override
  public Integer value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof CantidadItem)) {
      return false;
    }
    CantidadItem cantidadItem = (CantidadItem) o;
    return Objects.equals(value, cantidadItem.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
  
}
