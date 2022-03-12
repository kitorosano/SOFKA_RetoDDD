package uy.com.sofka.biblioteca.categoria.value;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class EstadoLibro implements ValueObject<String> {
  private final String value;

  public EstadoLibro(String value) {
    this.value = Objects.requireNonNull(value).trim();

    if(this.value.isBlank())
      throw new IllegalArgumentException("El estado del libro no puede estar vacio");
  }

  @Override
  public String value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof EstadoLibro)) {
      return false;
    }
    EstadoLibro estadoLibro = (EstadoLibro) o;
    return Objects.equals(value, estadoLibro.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
  
}