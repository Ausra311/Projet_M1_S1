package fc;
import java.util.Vector;

public class Film {
    String titre;
    String realisateur;
    Vector<String> acteurs;
    String resume;
    /* Genre??? */
    int restriction;
    int nb_location;

    Film(String _titre,
        String _realisateur, 
        Vector<String> _acteurs, 
        String _resume,
        int _restriction,
        int _nb){


        titre = _titre;
        realisateur = _realisateur;
        acteurs = _acteurs;
        resume = _resume;
        restriction = _restriction;
        nb_location = _nb;

    }

    String get_titre(){
        return titre;
    }

    String get_realisateur(){
        return realisateur;
    }

    Vector<String> get_acteurs(){
        return acteurs;
    } 
    String get_resume(){
        return resume;
    }
    int get_restriction(){
        return restriction;
    }
    int get_nb_location(){
        return nb_location;
    }

     

}