package fc;

import java.util.Vector;

public class Abonne_enfant  extends Abonne{
    private Vector<String> restriction_categorie;
    private int restriction_age;


    //Get :
    public int get_age(){
        return restriction_age;
    };

    public Vector<String> get_restriction_categorie(){
        return restriction_categorie;
    }

    //Set :
    public void add_restriction_categorie(String categorie){
        restriction_categorie.add(categorie);
    }

    public void add_restriction_age(int age){
        if(age==18 || age==16 || age==12 || age==10){
            restriction_age = age;
        }
    }

    public void remove_restriction_categorie(String categorie){
        restriction_categorie.remove(categorie);
    }

    public void remove_restriction_age(int age){
        if(age==18 || age==16 || age==12 || age==10){
            restriction_age = age;
        }
    }

    public void remove_restriction_age(){
        restriction_age = 0;
    }

    @Override 
    public String type_client(){
        return "Abonne_enfant";
    }
}
