
package ihm;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import fc.*;




public class PFilm extends JPanel{

    JFrame Fenetre;
    boolean connecter;
    BackgroundPanel affiche;
    Vector<Film> liste_films = new Vector<Film>();
    Interface inter;
    PFilm(int id,JFrame j,boolean c,Vector<Film>f,Interface i) {
        super();
        inter = i;
        liste_films =f;
        connecter =c;
        Fenetre = j;

        Film film = liste_films.get(0);
        for(int k=0;k<liste_films.size();k++){
            if(liste_films.get(k).get_id() == id){
                film = liste_films.get(k);
            }
        }
        
        
        JPanel espace = new JPanel();
        JButton Louer = new JButton("Louer");
        Louer.setPreferredSize(new Dimension(105,40));
        JLabel titre = new JLabel(film.get_titre());
        JLabel resume = new JLabel(film.get_resume());
        
        JLabel dispo;
        if(inter.dvd_dispo(film))
        {
            dispo = new JLabel("Disponible en DVD et QR code");
        }else{
            dispo = new JLabel("Disponible en QR code");
        }
        

        JPanel bouton = new JPanel();



        affiche = new BackgroundPanel("/images/"+film.get_id() + ".png",0);
        affiche.setPreferredSize(new Dimension(150,200));


        Louer.addActionListener(new ActionListener()
            {
            public void actionPerformed(ActionEvent e){
                Fenetre.setContentPane(new FicheFilm(id-1,Fenetre,connecter,inter));
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