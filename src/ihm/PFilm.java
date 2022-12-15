
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
    Film film;
    PFilm(int id,JFrame j,boolean c,Vector<Film>f,Interface i,boolean dvd) {
        super();
        inter = i;
        liste_films =f;
        connecter =c;
        Fenetre = j;

        film = liste_films.get(0);
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
            dispo = new JLabel("<html><br/>Disponible en DVD et QR code<html>");
        }else{
            dispo = new JLabel("<html><br/>Disponible en QR code<html>");
        }

        JPanel bouton = new JPanel();
        JPanel centre = new JPanel();
        centre.setLayout(new StackLayout());

        String currentPath = System.getProperty("user.dir");
        affiche = new BackgroundPanel(currentPath+"/src/ihm/images/"+film.get_id() + ".png",0);
        affiche.setPreferredSize(new Dimension(150,200));

        Louer.addActionListener(new ActionListener()
            {
            public void actionPerformed(ActionEvent e){
                Fenetre.setContentPane(new FicheFilm(id-1,Fenetre,connecter,inter,film,dvd));
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
        titre.setFont(new Font("Arial",Font.BOLD,20));
        centre.add(titre);
        centre.add(resume);
        centre.add(dispo);
        add(centre,BorderLayout.CENTER);
    }  
}