package uy.com.sofka.biblioteca.categoria.value;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class TemaLibro implements ValueObject<String> {
  private final String value;

  public TemaLibro(String value) {
    this.value = Objects.requireNonNull(value).trim();

    if(this.value.isBlank())
      throw new IllegalArgumentException("El nombre no puede estar vacio");

    if(this.value.length() <= 3)
      throw new IllegalArgumentException("El nombre debe tener minimo 3 caracteres");
      
    if(this.value.length() >= 20)
      throw new IllegalArgumentException("El nombre debe tener maximo 20 caracteres");
  }

  @Override
  public String value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof TemaLibro)) {
      return false;
    }
    TemaLibro temaLibro = (TemaLibro) o;
    return Objects.equals(value, temaLibro.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
  
}