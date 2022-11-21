package ihm;


import javax.swing.*;

public class Main {

    public static void main(String argv[]) {
        JFrame Fenetre = new JFrame();
        Accueil accueil = new Accueil(Fenetre);
        
        // Fenetre
        Fenetre.setContentPane(accueil);
        Fenetre.setName("AL2000");
	    Fenetre.setSize(1200,800);
	    Fenetre.setVisible(true);
    }

}
