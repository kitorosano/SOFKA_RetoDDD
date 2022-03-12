package uy.com.sofka.biblioteca.categoria.value;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class CopiasLibro implements ValueObject<Integer> {
  private final Integer value;

  public CopiasLibro(Integer value) {
    this.value = Objects.requireNonNull(value);

    if(this.value < 0)
      throw new IllegalArgumentException("Las cantidad de copias de un libro no puede ser negativa.");
  }

  public CopiasLibro generar(Integer value) {
    return new CopiasLibro(this.value + value);
  }

  public CopiasLibro remover(Integer value) {
      return new CopiasLibro(this.value - value);
  }

  @Override
  public Integer value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof CopiasLibro)) {
      return false;
    }
    CopiasLibro copiasLibro = (CopiasLibro) o;
    return Objects.equals(value, copiasLibro.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
  
}