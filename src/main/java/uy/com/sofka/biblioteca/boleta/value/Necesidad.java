package uy.com.sofka.biblioteca.boleta.value;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class Necesidad implements ValueObject<String> {
  private final String value;

  public Necesidad(String value) {
    this.value = Objects.requireNonNull(value).trim();

    if(this.value.isBlank())
      throw new IllegalArgumentException("La necesidad de la boletae no pueden estar vacia");

    if(this.value.length() <= 5)
      throw new IllegalArgumentException("La necesidad de la boletae debe tener minimo 5 caracteres");
      
    if(this.value.length() >= 30)
      throw new IllegalArgumentException("La necesidad de la boletae debe tener maximo 30 caracteres");
  }

  @Override
  public String value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Necesidad)) {
      return false;
    }
    Necesidad necesidad = (Necesidad) o;
    return Objects.equals(value, necesidad.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

}
