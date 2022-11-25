package ihm;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class FicheFilm extends JPanel {
    boolean connecter;
    BackgroundPanel affiche;
    FicheFilm(int id,JFrame f,boolean c) {
    connecter =c;
    JFrame Fenetre = f;
    JPanel Sud = new JPanel();
    JPanel Centre = new JPanel();
    JButton LouerQR = new JButton("LouerQR");
    JButton LouerDVD = new JButton("LouerDVD");
    JPanel Location = new JPanel();
    JButton Retour = new JButton("Retour");
    boolean dispoDVD = true;
    JTextArea resume ;
    
    Retour.setPreferredSize(new Dimension(110,50));
    //LouerDVD.setPreferredSize(new Dimension(600,50));
    //LouerQR.setPreferredSize(new Dimension(600,50));
    
    switch(id){
        case 0:
            resume = new JTextArea("kiki la sorciere");
            affiche = new BackgroundPanel("C:/Users/beren/Documents/Master/TLI/Projet/src/ihm/images/kiki.jpg",1);
        break;
        case 1:
            resume = new JTextArea("Ouuuuaaah c'est la merde");
            affiche = new BackgroundPanel("C:/Users/beren/Documents/Master/TLI/Projet/src/ihm/images/starwars3.png",1);
        break;
        default:
            resume = new JTextArea("404 not found");
            affiche = new BackgroundPanel("C:/Users/beren/Documents/Master/TLI/Projet/src/ihm/images/404.png",1);
        break;
    }
    resume.setEditable(false);
    Retour.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Films(Fenetre,connecter));
            Fenetre.revalidate();
            }
    });
    LouerDVD.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e){
            if(connecter){
            Fenetre.setContentPane(new Louer_abo(Fenetre,connecter));
            Fenetre.revalidate();
            }
            else{
                Fenetre.setContentPane(new Louer_non_abo(Fenetre));
                Fenetre.revalidate();
            }
        }
    });
    LouerQR.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e){
            if(connecter){
            Fenetre.setContentPane(new Louer_abo(Fenetre,connecter));
            Fenetre.revalidate();
            }
            else{
                Fenetre.setContentPane(new Louer_non_abo(Fenetre));
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
    Centre.add(resume,BorderLayout.CENTER);
    if((!dispoDVD)){
        LouerDVD.setVisible(false);
    }
    Location.add(LouerDVD);
    Location.add(LouerQR);
    Sud.add(Retour,BorderLayout.WEST);
    Sud.add(Location,BorderLayout.CENTER);
    
    add(Centre,BorderLayout.CENTER);
    add(Sud,BorderLayout.SOUTH);
}
}