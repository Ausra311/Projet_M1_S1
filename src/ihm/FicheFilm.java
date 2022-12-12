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
    FicheFilm(int id,JFrame f,boolean c,Interface i) {
    connecter =c;
    inter = i;
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
    
    switch(id){
        case 0:
            resume = new JTextArea("kiki la sorciere");
            affiche = new BackgroundPanel("/images/0.png",1);
        break;
        case 1:
            resume = new JTextArea("Ouuuuaaah c'est la merde");
            affiche = new BackgroundPanel("/images/1.png",1);
        break;
        default:
            resume = new JTextArea("404 not found");
            affiche = new BackgroundPanel("/images/err404.png",1);
        break;
    }
    resume.setEditable(false);
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
            if(connecter){
            Fenetre.setContentPane(new Louer_abo(Fenetre,connecter,inter));
            Fenetre.revalidate();
            }
            else{
                Fenetre.setContentPane(new Louer_non_abo(Fenetre,inter));
                Fenetre.revalidate();
            }
        }
    });
    LouerQR.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e){
            if(connecter){
            Fenetre.setContentPane(new Louer_abo(Fenetre,connecter,inter));
            Fenetre.revalidate();
            }
            else{
                Fenetre.setContentPane(new Louer_non_abo(Fenetre,inter));
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