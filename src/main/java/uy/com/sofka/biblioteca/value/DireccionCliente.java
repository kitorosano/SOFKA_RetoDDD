package uy.com.sofka.biblioteca.value;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class DireccionCliente implements ValueObject<String> {
  private final String value;

  public DireccionCliente(String value) {
    this.value = Objects.requireNonNull(value).trim();

    if(this.value.isBlank())
      throw new IllegalArgumentException("La direccion no puede estar vacia");

    if(this.value.length() <= 5)
      throw new IllegalArgumentException("Debes de tener mayor a 5 caracteres");
  }

  @Override
  public String value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof DireccionCliente)) {
      return false;
    }
    DireccionCliente direccionCliente = (DireccionCliente) o;
    return Objects.equals(value, direccionCliente.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
  
}
