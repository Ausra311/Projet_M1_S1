package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class Connexion extends JPanel{

    boolean connecter;
    int pred;
    int id = 0 ;
    Connexion(JFrame f, boolean c,int p){
        pred = p;
        JFrame Fenetre = f;
        setLayout(new BorderLayout());
        JTextField identifiant = new JTextField("");
        JPanel sud = new JPanel();
        JPanel centre = new JPanel();
        JButton Inserer_carte = new JButton("Inserer carte");
        JButton Retour = new JButton("Retour");
        JLabel iden= new JLabel("Identifiant :");
        JPanel conn = new JPanel();
        JPanel conn2 = new JPanel();
        identifiant.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(((c<'0')||(c>'9'))&&(c != KeyEvent.VK_BACK_SPACE)){
                    e.consume();
                }
            }
        });
        // Placement
        JPanel haut = new JPanel(); 
        haut.setPreferredSize(new Dimension(600,400));
        
        //Boutons
        Inserer_carte.setPreferredSize(new Dimension(400,80));
        Inserer_carte.setFont(new Font("Arial",Font.BOLD,25));
        Inserer_carte.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            if(pred == 0){
                String s = identifiant.getText();
                if(!s.equals("")){
                    id = Integer.parseInt(s);
                }
                Fenetre.setContentPane(new Films(Fenetre,true));
            }else{
                String s = identifiant.getText();
                if(!s.equals("")){
                    id = Integer.parseInt(s);
                }
                Fenetre.setContentPane(new Louer_abo(Fenetre,true));        
            }
            
            Fenetre.revalidate();
            }
        });

        Retour.setPreferredSize(new Dimension(110,50));
        Retour.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            if(pred ==0){
                Fenetre.setContentPane(new Accueil(Fenetre,connecter));
            }else{
                Fenetre.setContentPane(new Louer_non_abo(Fenetre));
            }
            Fenetre.revalidate();
            }
        });
        identifiant.setPreferredSize(new Dimension(30,25));
        conn.add(iden);
        conn.add(identifiant);
        centre.setLayout(new StackLayout());
        conn2.add(Inserer_carte);
        centre.add(conn2);
        centre.add(conn);
        sud.setLayout(new BorderLayout());
        sud.add(Retour,BorderLayout.WEST);

        //Panel principal
        add(centre,BorderLayout.CENTER);
        add(sud,BorderLayout.SOUTH);
        add(haut,BorderLayout.NORTH);

    }
}