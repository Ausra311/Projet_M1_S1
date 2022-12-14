package ihm;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import fc.*;

public class GestionCompte extends JPanel {
    JFrame Fenetre;
    Interface inter;
    GestionCompte(JFrame j,Interface i,Film film,boolean dvd){
        Fenetre =j;
        inter =i;
        setLayout(new BorderLayout());
        JPanel centre = new JPanel();
        JPanel sud = new JPanel();
        JPanel espace = new JPanel();
        JPanel espace2 = new JPanel();
        JPanel espace3 = new JPanel();
        JPanel espace4 = new JPanel();
        espace.setPreferredSize(new Dimension(20,120));
        espace2.setPreferredSize(new Dimension(20,120));
        espace3.setPreferredSize(new Dimension(20,120));
        espace4.setPreferredSize(new Dimension(20,120));
        centre.setLayout(new GridLayout(1,2));
        sud.setLayout(new BorderLayout());
        
        Client client = inter.get_client();
        String info_perso = "\n\nNom : "+client.get_nom()+"\n\nPrenom : "+client.get_prenom()+ "\n\nAdresse : " + client.get_adresse() + "\n\nTelephone : " + client.get_telephone() + "\n\nSolde : " +client.get_solde();
        TextArea Infos = new TextArea(info_perso);
        Infos.setFont(new Font("Arial",Font.CENTER_BASELINE,25));
        Infos.setEditable(false);
        
        JPanel boutons = new JPanel();
        boutons.setLayout(new StackLayout());
        JButton Histo = new JButton("Historique");
        Histo.setPreferredSize(new Dimension(110,50));
        Histo.setFont(new Font("Arial",Font.BOLD,25));
        JButton Deconnexion = new JButton("Deconnexion");
        Deconnexion.setPreferredSize(new Dimension(110,50));
        Deconnexion.setFont(new Font("Arial",Font.BOLD,25));
        JButton Recharger = new JButton("Recharger");
        Recharger.setPreferredSize(new Dimension(110,50));
        Recharger.setFont(new Font("Arial",Font.BOLD,25));
        JButton GererMioche = new JButton("Gérer compte enfant");
        GererMioche.setFont(new Font("Arial",Font.BOLD,25)); 
        GererMioche.setPreferredSize(new Dimension(110,50));
        JButton Retour = new JButton("Retour");
        Retour.setPreferredSize(new Dimension(110,50));
        Retour.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Films(Fenetre,true,inter));
            Fenetre.revalidate();
            }
        });
        Deconnexion.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Accueil(Fenetre,false,inter));
            Fenetre.revalidate();
            }
        });
        Histo.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Histo(Fenetre,inter,film,dvd));
            Fenetre.revalidate();
            }
        });
        Recharger.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Recharger(Fenetre,0,inter,film,dvd));
            Fenetre.revalidate();
            }
        });
        GererMioche.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Gerer_gosse(Fenetre,inter,film,dvd));
            Fenetre.revalidate();
            }
        });

        sud.add(Retour,BorderLayout.WEST);
        boutons.add(espace);
        boutons.add(Histo);
        boutons.add(espace2);
        boutons.add(Recharger);
        boutons.add(espace3);
        boutons.add(GererMioche);
        boutons.add(espace4);
        boutons.add(Deconnexion);
        centre.add(Infos);
        centre.add(boutons);
        add(centre,BorderLayout.CENTER);
        add(sud,BorderLayout.SOUTH);


    }
    
}
