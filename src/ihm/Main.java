package ihm;


import javax.swing.*;
import fc.*;
import java.awt.Toolkit;

public class Main {

    public static void main(String argv[]) {
        Interface inter = new Interface();
        JFrame Fenetre = new JFrame();
        boolean connecter = false;
        Accueil accueil = new Accueil(Fenetre,connecter,inter);
        //BackgroundPanel back = new BackgroundPanel("C:/Users/beren/Documents/Master/TLI/Projet/src/ihm/images/test_fond.png");
        // Fenetre

        Fenetre.setContentPane(accueil);
        Fenetre.setTitle("AL2000");
        Fenetre.setSize(Toolkit.getDefaultToolkit().getScreenSize());
	    //Fenetre.setSize(1200,800);
	    Fenetre.setVisible(true);
    }

}
