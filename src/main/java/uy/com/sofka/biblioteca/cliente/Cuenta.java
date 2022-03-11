package uy.com.sofka.biblioteca.cliente;

import java.util.Objects;

import co.com.sofka.domain.generic.Entity;
import uy.com.sofka.biblioteca.cliente.value.ProveedorCuenta;
import uy.com.sofka.biblioteca.cliente.value.CuentaId;
import uy.com.sofka.biblioteca.cliente.value.CorreoCuenta;
import uy.com.sofka.biblioteca.cliente.value.NombreUsuarioCuenta;

public class Cuenta extends Entity<CuentaId> {
  protected NombreUsuarioCuenta nombreUsuario;
  protected CorreoCuenta correo;
  protected ProveedorCuenta proveedor;

  public Cuenta(CuentaId cuentaId, NombreUsuarioCuenta nombreUsuario, CorreoCuenta correo, ProveedorCuenta proveedor) {
    super(cuentaId);
    this.nombreUsuario = nombreUsuario;
    this.correo = correo;
    this.proveedor = proveedor;
  }

  // metodos (setters)
  public void modificarNombreUsuario(NombreUsuarioCuenta nombreUsuario) {
    this.nombreUsuario = Objects.requireNonNull(nombreUsuario);
  }
  
  //Getters
  public NombreUsuarioCuenta nombreUsuario() {
    return nombreUsuario;
  }
  
  public CorreoCuenta correo() {
    return correo;
  }

  public ProveedorCuenta proveedor() {
    return proveedor;
  }
  
}
