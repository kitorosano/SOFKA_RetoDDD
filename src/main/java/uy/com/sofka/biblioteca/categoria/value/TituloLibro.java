package uy.com.sofka.biblioteca.categoria.value;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class TituloLibro implements ValueObject<String> {
  private final String value;

  public TituloLibro(String value) {
    this.value = Objects.requireNonNull(value).trim();

    if(this.value.isBlank())
      throw new IllegalArgumentException("El titulo del libro no puede estar vacio");

    if(this.value.length() <= 3)
      throw new IllegalArgumentException("El titulo del libro debe tener minimo 3 caracteres");
      
    if(this.value.length() >= 25)
      throw new IllegalArgumentException("El titulo del libro debe tener maximo 25 caracteres");
  }

  @Override
  public String value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof TituloLibro)) {
      return false;
    }
    TituloLibro tituloLibro = (TituloLibro) o;
    return Objects.equals(value, tituloLibro.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
  
}
