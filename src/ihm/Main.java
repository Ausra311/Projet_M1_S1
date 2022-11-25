package ihm;


import javax.swing.*;

public class Main {

    public static void main(String argv[]) {
        JFrame Fenetre = new JFrame();
        boolean connecter = false;
        Accueil accueil = new Accueil(Fenetre,connecter);
        //BackgroundPanel back = new BackgroundPanel("C:/Users/beren/Documents/Master/TLI/Projet/src/ihm/images/test_fond.png");
        // Fenetre

        Fenetre.setContentPane(accueil);
        Fenetre.setTitle("AL2000");
	    Fenetre.setSize(1200,800);
	    Fenetre.setVisible(true);
    }

}
