
package ihm;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;




public class Film extends JPanel{

    JFrame Fenetre;
    boolean connecter;
    BackgroundPanel affiche;
    Film(int id,JFrame j,boolean c) {
        super();
        connecter =c;
        Fenetre = j;
        JTextField resume;
        JPanel espace = new JPanel();
        JButton Louer = new JButton("Louer");
        Louer.setPreferredSize(new Dimension(105,40));
        JLabel titre = new JLabel("KiKi");
        JLabel dispoQR = new JLabel("Disponible en QR code uniquement");
        JLabel dispo = new JLabel("Disponible en DVD et QR code");

        affiche = new BackgroundPanel("C:/Users/beren/Documents/Master/TLI/Projet/src/ihm/images/kiki.jpg",0);
        affiche.setPreferredSize(new Dimension(150,200));

        JPanel bouton = new JPanel();


        switch(id){
            case 1 :
                resume = new JTextField("Kiki \n C'est une sorciere");
                affiche = new BackgroundPanel("C:/Users/beren/Documents/Master/TLI/Projet/src/ihm/images/kiki.jpg",0);
                affiche.setPreferredSize(new Dimension(150,200));
                break;
            case 2 :
                resume = new JTextField("Anakin le fragil");
                affiche = new BackgroundPanel("C:/Users/beren/Documents/Master/TLI/Projet/src/ihm/images/starwars3.png",0);
                affiche.setPreferredSize(new Dimension(150,200));
            break;
            default:
                resume = new JTextField("film numero :" + id);
                affiche = new BackgroundPanel("C:/Users/beren/Documents/Master/TLI/Projet/src/ihm/images/404.png",0);
                affiche.setPreferredSize(new Dimension(150,200));
            break;
        }

        resume.setEditable(false);
        Louer.addActionListener(new ActionListener()
            {
            public void actionPerformed(ActionEvent e){
                Fenetre.setContentPane(new FicheFilm(id-1,Fenetre,connecter));
                Fenetre.revalidate();
                }
            });
        Louer.setPreferredSize(new Dimension(150,50));
        espace.setPreferredSize(new Dimension(150,50));
        bouton.setLayout(new StackLayout());
        setLayout(new BorderLayout());

        add(affiche,BorderLayout.WEST);
        bouton.add(espace);
        bouton.add(Louer);
        add(bouton,BorderLayout.EAST);
        add(resume,BorderLayout.CENTER);
    }  
}