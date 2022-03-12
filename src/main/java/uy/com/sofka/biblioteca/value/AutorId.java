package uy.com.sofka.biblioteca.value;

import co.com.sofka.domain.generic.Identity;

public class AutorId extends Identity{
  
  public AutorId(){
    
  }

  private AutorId(String id){
    super (id);
  }

  public static AutorId of (String id){
    return new AutorId(id);
  }
}
