package ihm;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import fc.*;

public class FicheFilm extends JPanel {
    boolean connecter;
    BackgroundPanel affiche;
    Interface inter;
    Film film;
    boolean dvd;
    FicheFilm(int id,JFrame f,boolean c,Interface i,Film fi,boolean d) {
    connecter =c;
    inter = i;
    film = fi;
    dvd = d;
    JFrame Fenetre = f;
    JPanel Sud = new JPanel();
    JPanel Centre = new JPanel();
    JButton LouerQR = new JButton("LouerQR");
    JButton LouerDVD = new JButton("LouerDVD");
    JPanel Location = new JPanel();
    JButton Retour = new JButton("Retour");
    boolean dispoDVD = inter.dvd_dispo(fi);
    JPanel centre2 = new JPanel();
    JLabel real = new JLabel("<html><br/>Réalisateur : " + film.get_realisateur()+"<html>");
    JLabel acteur = new JLabel("<html><br/>Acteur : "+film.get_acteurs().toString().substring(1,film.get_acteurs().toString().length()-1)+"<html>");
    centre2.setLayout(new StackLayout());
    JLabel genre = new JLabel("<html><br/>Genre : " + film.get_genre().toString().substring(1,film.get_genre().toString().length()-1)+"<html>");
    JLabel titre = new JLabel(film.get_titre());
    titre.setFont(new Font("Arial",Font.BOLD,40));
    JLabel age = new JLabel("<html><br/>Age recommandé : " + film.get_restriction()+"<br/>");
    
    JLabel resume = new JLabel(film.get_resume());
    
    Retour.setPreferredSize(new Dimension(110,50));
    String currentPath = System.getProperty("user.dir");

    affiche = new BackgroundPanel(currentPath+"/src/ihm/images/"+film.get_id()+".png",1);
    Retour.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Films(Fenetre,connecter,inter));
            Fenetre.revalidate();
            }
    });
    LouerDVD.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e){
            dvd = true;
            if(connecter){
            Fenetre.setContentPane(new Louer_abo(Fenetre,connecter,inter,film,dvd));
            Fenetre.revalidate();
            }
            else{
                Fenetre.setContentPane(new Louer_non_abo(Fenetre,inter,film,dvd));
                Fenetre.revalidate();
            }
        }
    });
    LouerQR.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e){
            dvd = false;
            if(connecter){
            Fenetre.setContentPane(new Louer_abo(Fenetre,connecter,inter,film,dvd));
            Fenetre.revalidate();
            }
            else{
                Fenetre.setContentPane(new Louer_non_abo(Fenetre,inter,film,dvd));
                Fenetre.revalidate();
            }
        }
    });
    Location.setLayout(new GridLayout(1,2));
    setLayout(new BorderLayout());
    Sud.setLayout(new BorderLayout());
    Centre.setLayout(new BorderLayout());
    affiche.setPreferredSize(new Dimension(500,100));
    Centre.add(affiche,BorderLayout.WEST);
    resume.setFont(new Font("Arial",Font.CENTER_BASELINE,20));
    real.setFont(new Font("Arial",Font.CENTER_BASELINE,20));
    acteur.setFont(new Font("Arial",Font.CENTER_BASELINE,20));
    genre.setFont(new Font("Arial",Font.CENTER_BASELINE,20));
    centre2.add(titre);
    centre2.add(resume);
    centre2.add(real);
    centre2.add(acteur);
    centre2.add(genre);
    Centre.add(centre2,BorderLayout.CENTER);


    LouerDVD.setEnabled(dispoDVD);
    
    Location.add(LouerDVD);
    Location.add(LouerQR);
    Sud.add(Retour,BorderLayout.WEST);
    Sud.add(Location,BorderLayout.CENTER);
    
    add(Centre,BorderLayout.CENTER);
    add(Sud,BorderLayout.SOUTH);
}
}