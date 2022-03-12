package uy.com.sofka.biblioteca.categoria.value;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class DescripcionBloque implements ValueObject<String> {
  private final String value;

  public DescripcionBloque(String value) {
    this.value = Objects.requireNonNull(value).trim();

    if(this.value.isBlank())
      throw new IllegalArgumentException("La descripcion del bloque no puede estar vacia");

    if(this.value.length() <= 10)
      throw new IllegalArgumentException("La descripcion del bloque debe tener minimo 10 caracteres");
      
    if(this.value.length() >= 40)
      throw new IllegalArgumentException("La descripcion del bloque debe tener maximo 40 caracteres");
  }

  @Override
  public String value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof DescripcionBloque)) {
      return false;
    }
    DescripcionBloque descripcionBloque = (DescripcionBloque) o;
    return Objects.equals(value, descripcionBloque.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
  
}