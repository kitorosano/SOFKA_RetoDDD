package uy.com.sofka.biblioteca.boleta;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import uy.com.sofka.biblioteca.boleta.events.*;
import uy.com.sofka.biblioteca.boleta.value.*;
import uy.com.sofka.biblioteca.categoria.value.CategoriaId;
import uy.com.sofka.biblioteca.categoria.value.LibroId;
import uy.com.sofka.biblioteca.value.*;

public class Boleta extends AggregateEvent<BoletaId> {
  protected Necesidad necesidad;
  protected Fecha fecha;
  protected FechaDevolucion fechaDevolucion;
  protected Multa multa;
  protected Cliente cliente;
  protected Set<Item> items;

  /** Constructores */
  public Boleta(BoletaId entityId, Necesidad necesidad, Fecha fecha, FechaDevolucion fechaDevolucion) {
    super(entityId);
    appendChange(new BoletaCreada(necesidad, fecha, fechaDevolucion)).apply(); //Crar obj Boleta
  }
  
  private Boleta(BoletaId boletaId){
    super(boletaId);
    subscribe(new BoletaChange(this));
  }

  public static Boleta from(BoletaId boletaId, List<DomainEvent> events){
    var boleta = new Boleta(boletaId);
    events.forEach(boleta::applyEvent); //recrea todos los agregados apartir de eventos guardados
    return boleta;
  }
  
  /** Metodos */  
  public void modificarNecesidad(Necesidad necesidad){
    Objects.requireNonNull(necesidad);
    appendChange(new NecesidadModificada(necesidad)).apply();
  }
  
  public void modificarFechaDevolucion(FechaDevolucion fechaDevolucion){
    Objects.requireNonNull(fechaDevolucion);
    appendChange(new FechaDevolucionModificada(fechaDevolucion)).apply();
  }

  public void establecerMulta(MultaId multaId, CondicionesMulta condiciones, MontoMulta monto){
    Objects.requireNonNull(multaId);
    Objects.requireNonNull(condiciones);
    Objects.requireNonNull(monto);
    appendChange(new MultaEstablecida(multaId, condiciones, monto)).apply();
  } 
  
  public void modificarCondicionesMulta(MultaId multaId, CondicionesMulta condiciones){
    Objects.requireNonNull(multaId);
    Objects.requireNonNull(condiciones);
    appendChange(new CondicionesMultaModificada(multaId, condiciones)).apply();
  }

  public void modificarMontoMulta(MultaId multaId, MontoMulta monto){
    Objects.requireNonNull(multaId);
    Objects.requireNonNull(monto);
    appendChange(new MontoMultaModificada(multaId, monto)).apply();
  }

  public void asignarCliente(ClienteId clienteId, NombreCliente nombre, DireccionCliente direccion, TelefonoCliente telefono, CedulaCliente cedula) {
    Objects.requireNonNull(clienteId);
    Objects.requireNonNull(nombre);
    Objects.requireNonNull(direccion);
    Objects.requireNonNull(telefono);
    Objects.requireNonNull(cedula);
    appendChange(new ClienteAsignado(clienteId, nombre, direccion, telefono, cedula)).apply();
  } 
  
  public void modificarNombreCliente(ClienteId clienteId, NombreCliente nombre){
    Objects.requireNonNull(clienteId);
    Objects.requireNonNull(nombre);
    appendChange(new NombreClienteModificado(clienteId, nombre)).apply();
  }

  public void modificarDireccionCliente(ClienteId clienteId, DireccionCliente direccion){
    Objects.requireNonNull(clienteId);
    Objects.requireNonNull(direccion);
    appendChange(new DireccionClienteModificada(clienteId, direccion)).apply();
  }
  
  public void modificarTelefonoCliente(ClienteId clienteId, TelefonoCliente telefono){
    Objects.requireNonNull(clienteId);
    Objects.requireNonNull(telefono);
    appendChange(new TelefonoClienteModificado(clienteId, telefono)).apply();
  }

  public void agregarItem(ItemId itemId, LibroId libroId, CategoriaId categoriaId, CantidadItem cantidad){
    Objects.requireNonNull(itemId);
    Objects.requireNonNull(libroId);
    Objects.requireNonNull(categoriaId);
    Objects.requireNonNull(cantidad);
    appendChange(new ItemAgregado(itemId, libroId, categoriaId, cantidad)).apply();
  }

  public void removerItem(ItemId itemId){
    Objects.requireNonNull(itemId);
    appendChange(new ItemRemovido(itemId)).apply();
  }

  public void modificarCantidadItem(ItemId itemId, CantidadItem cantidad){
    Objects.requireNonNull(itemId);
    Objects.requireNonNull(cantidad);
    appendChange(new CantidadItemModificado(itemId, cantidad)).apply();
  }

  /** Getters */
  public Necesidad necesidad() {
    return necesidad;
  }

  public Fecha fecha() {
    return fecha;
  }

  public FechaDevolucion fechaDevolucion() {
    return fechaDevolucion;
  }

  public Multa multa() {
    return multa;
  }

  public Cliente cliente() {
    return cliente;
  }
  
  public Set<Item> items() {
    return items;
  }

  protected Optional<Item> getItemPorId(ItemId itemId){
    return items().stream().filter(key -> key.identity().equals(itemId)).findFirst();
  }
}