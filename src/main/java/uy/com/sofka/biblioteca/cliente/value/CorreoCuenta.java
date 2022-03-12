package uy.com.sofka.biblioteca.cliente.value;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class CorreoCuenta implements ValueObject<String> {
  private final String value;

  public CorreoCuenta(String value) {
    this.value = Objects.requireNonNull(value);

    if(this.value.isBlank())
      throw new IllegalArgumentException("El correo de la cuenta no puede estar vacio");
      
      
    if(this.value.length() <= 6)
      throw new IllegalArgumentException("El correo de la cuenta debe tener minimo 6 caracteres");

    if(!value.matches("^[_A-Za-z8-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,)$"))
      throw new IllegalArgumentException("El correo de la cuenta no es valido");
    
  }

  @Override
  public String value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof CorreoCuenta)) {
      return false; 
    }
    CorreoCuenta correoCuenta = (CorreoCuenta) o;
    return Objects.equals(value, correoCuenta.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

}
