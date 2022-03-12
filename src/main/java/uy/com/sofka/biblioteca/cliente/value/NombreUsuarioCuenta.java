package uy.com.sofka.biblioteca.cliente.value;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class NombreUsuarioCuenta implements ValueObject<String> {
  private final String value;

  public NombreUsuarioCuenta(String value) {
    this.value = Objects.requireNonNull(value).trim();

    if(this.value.isBlank())
      throw new IllegalArgumentException("El nombre de usuario de la cuenta no puede estar vacio");

    if(this.value.length() <= 5)
      throw new IllegalArgumentException("El nombre de usuario de la cuenta debe tener minimo 5 caracteres");
      
    if(this.value.length() >= 30)
      throw new IllegalArgumentException("El nombre de usuario de la cuenta debe tener maximo 30 caracteres");
  }

  @Override
  public String value() {
    return value;
  }
  

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof NombreUsuarioCuenta)) {
      return false;
    }
    NombreUsuarioCuenta nombreUsuarioCuenta = (NombreUsuarioCuenta) o;
    return Objects.equals(value, nombreUsuarioCuenta.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

}