package uy.com.sofka.biblioteca.categoria.value;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class PasilloBloque implements ValueObject<Integer> {
  private final Integer value;

  public PasilloBloque(Integer value) {
    this.value = Objects.requireNonNull(value);

    if(this.value < 0)
      throw new IllegalArgumentException("El numero de pasillo de un bloque no puede ser negativo.");
  }

  @Override
  public Integer value() {
    return value;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PasilloBloque)) {
            return false;
        }
        PasilloBloque pasilloBloque = (PasilloBloque) o;
        return Objects.equals(value, pasilloBloque.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
  
}
