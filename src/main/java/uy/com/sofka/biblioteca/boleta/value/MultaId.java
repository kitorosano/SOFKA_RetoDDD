package uy.com.sofka.biblioteca.boleta.value;

import co.com.sofka.domain.generic.Identity;

public class MultaId extends Identity{

  public MultaId(){
    
  }

  private MultaId(String id){
    super (id);
  }

  public static MultaId of (String id){
    return new MultaId(id);
  }
}
