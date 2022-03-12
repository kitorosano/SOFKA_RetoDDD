package uy.com.sofka.biblioteca.categoria.value;

import co.com.sofka.domain.generic.Identity;

public class CategoriaId extends Identity {
  
  public CategoriaId(){
    
  }

  private CategoriaId(String id){
    super (id);
  }

  public static CategoriaId of (String id){
    return new CategoriaId(id);
  }
}
