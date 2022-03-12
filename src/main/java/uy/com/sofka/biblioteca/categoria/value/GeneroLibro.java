package uy.com.sofka.biblioteca.categoria.value;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class GeneroLibro implements ValueObject<String> {
  private final String value;

  public GeneroLibro(String value) {
    this.value = Objects.requireNonNull(value).trim();

    if(this.value.isBlank())
      throw new IllegalArgumentException("El genero no puede estar vacio");

    if(this.value.length() <= 3)
      throw new IllegalArgumentException("El genero debe tener minimo 3 caracteres");
      
    if(this.value.length() >= 20)
      throw new IllegalArgumentException("El genero debe tener maximo 20 caracteres");
  }

  @Override
  public String value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof GeneroLibro)) {
      return false;
    }
    GeneroLibro generoLibro = (GeneroLibro) o;
    return Objects.equals(value, generoLibro.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
  
}