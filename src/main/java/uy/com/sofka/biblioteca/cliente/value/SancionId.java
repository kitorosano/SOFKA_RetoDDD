package uy.com.sofka.biblioteca.cliente.value;

import co.com.sofka.domain.generic.Identity;

public class SancionId extends Identity{

  public SancionId(){
    
  }

  private SancionId(String id){
    super (id);
  }

  public static SancionId of (String id){
    return new SancionId(id);
  }
}
