package fc;

import java.util.Date;

public class Client {
    private String type;
    private int nb_film_en_location;

    Client(){}

     
   public void debiter(){

    }
    public Boolean peut_louer(){
        return true;
    }
    public Boolean solde_suffisant(){
      return true;  
    }
   String type_client(){
    return "Carte Bancaire";
   }

    //get
    public String type(){
        return type;
   }
   public int nb_film_en_location(){
        return nb_film_en_location;
   }
   
    //set
   public void add_film_loc(){
     nb_film_en_location +=1;
   }
   public void rm_film_loc(){
    nb_film_en_location -=1;
   }
  
}
