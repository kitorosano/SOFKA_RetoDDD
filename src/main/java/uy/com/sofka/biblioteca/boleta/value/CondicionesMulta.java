package uy.com.sofka.biblioteca.boleta.value;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class CondicionesMulta implements ValueObject<String> {
  private final String value;

  public CondicionesMulta(String value) {
    this.value = Objects.requireNonNull(value).trim();

    if(this.value.isBlank())
      throw new IllegalArgumentException("Las condiciones de multa no pueden ser vacias");

    if(this.value.length() <= 15)
      throw new IllegalArgumentException("Las condiciones de multa debe tener minimo 15 caracteres");
      
    if(this.value.length() >= 200)
      throw new IllegalArgumentException("Las condiciones de multa debe tener maximo 200 caracteres");
  }

  @Override
  public String value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof CondicionesMulta)) {
      return false;
    }
    CondicionesMulta condicionesMulta = (CondicionesMulta) o;
    return Objects.equals(value, condicionesMulta.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
  
}
