package uy.com.sofka.biblioteca.categoria.value;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class AcotacionLibro implements ValueObject<String> {
  private final String value;

  public AcotacionLibro(String value) {
    this.value = Objects.requireNonNull(value).trim();

    if(this.value.isBlank())
      throw new IllegalArgumentException("La acotacion del libro no puede estar vacia");

    if(this.value.length() <= 15)
      throw new IllegalArgumentException("La acotacion del libro debe tener minimo 15 caracteres");
      
    if(this.value.length() >= 150)
      throw new IllegalArgumentException("La acotacion del libro debe tener maximo 150 caracteres");
  }

  @Override
  public String value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof AcotacionLibro)) {
      return false;
    }
    AcotacionLibro acotacionLibro = (AcotacionLibro) o;
    return Objects.equals(value, acotacionLibro.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
  
}