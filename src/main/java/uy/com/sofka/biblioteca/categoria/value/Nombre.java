package uy.com.sofka.biblioteca.categoria.value;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class Nombre implements ValueObject<String> {
  private final String value;

  public Nombre(String value) {
    this.value = Objects.requireNonNull(value).trim();

    if(this.value.isBlank())
      throw new IllegalArgumentException("El nombre de la categoria no puede estar vacio");

    if(this.value.length() <= 4)
      throw new IllegalArgumentException("El nombre de la categoria debe tener minimo 4 caracteres");
      
    if(this.value.length() >= 25)
      throw new IllegalArgumentException("El nombre de la categoria debe tener maximo 25 caracteres");
  }

  @Override
  public String value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
      if (o == this)
          return true;
      if (!(o instanceof Nombre)) {
          return false;
      }
      Nombre nombre = (Nombre) o;
      return Objects.equals(value, nombre.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
  
}
