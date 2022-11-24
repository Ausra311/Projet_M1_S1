package ihm;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class FicheFilm extends JPanel {
    boolean connecter;
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
    JTextArea resume = new JTextArea("kiki la sorciere");
    Retour.setPreferredSize(new Dimension(110,50));
    //LouerDVD.setPreferredSize(new Dimension(600,50));
    //LouerQR.setPreferredSize(new Dimension(600,50));
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