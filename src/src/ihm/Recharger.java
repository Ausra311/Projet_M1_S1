package ihm;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import fc.*;

public class Recharger extends JPanel {
       JFrame Fenetre;
       int pred;
       Interface inter;
       Recharger(JFrame f, int i,Interface in,Film film) {
              Fenetre = f;
              pred = i;
              inter = in;

              JPanel haut = new JPanel();
              haut.setPreferredSize(new Dimension(600,400));
              JPanel centre = new JPanel();
              JPanel centre1 = new JPanel();
              JPanel centre2 = new JPanel();
              JPanel sud = new JPanel();
              JLabel choix = new JLabel("Choix montant (10 euros minimum): "); 
              JLabel euro = new JLabel("€");
              JButton Payer = new JButton("Payer");
              JButton retour = new JButton("Retour");
              JTextField montant = new JTextField();
              JPanel centre3 = new JPanel();
              int solde = 15; // a récupérer dans la bd
              JLabel info_solde = new JLabel("Votre solde est de : "+ solde +" euros");
              info_solde.setFont(new Font("Arial",Font.CENTER_BASELINE,20)); 
              info_solde.setFont(new Font("Arial",Font.BOLD,20));
              Payer.setFont(new Font("Arial",Font.BOLD,20));
              
              JButton terminer = new JButton("Terminer");
              terminer.setFont(new Font("Arial",Font.BOLD,15));


              montant.setPreferredSize(new Dimension(100,30));
              Payer.setPreferredSize(new Dimension(150,40));
              choix.setPreferredSize(new Dimension(275,50));
              euro.setPreferredSize(new Dimension(15,50));
              choix.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
              montant.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
              euro.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
              Payer.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
              Payer.addActionListener(new ActionListener()
              {
                     public void actionPerformed(ActionEvent e){
                            String prix = montant.getText();
                            JLabel paye = new JLabel("Rechargement de "+ prix +" euros effectué");
                            centre3.add(paye);
                            centre3.add(terminer);
                            centre3.setVisible(true);
                            Payer.setVisible(false);

                     }
              
              });

              retour.setPreferredSize(new Dimension(110,50));
              retour.addActionListener(new ActionListener()
              {
                     public void actionPerformed(ActionEvent e){
                     if(pred==0){
                            Fenetre.setContentPane(new GestionCompte(Fenetre,inter,film));
                            Fenetre.revalidate();
                     }else{
                            Fenetre.setContentPane(new Louer_abo(Fenetre,true,inter,film));
                            Fenetre.revalidate();                
                     }
              }
              });
              terminer.addActionListener(new ActionListener()
              {
                     public void actionPerformed(ActionEvent e){
                     if(pred==0){
                            Fenetre.setContentPane(new GestionCompte(Fenetre,inter,film));
                            Fenetre.revalidate();
                     }else{
                            Fenetre.setContentPane(new Louer_abo(Fenetre,true,inter,film));
                            Fenetre.revalidate();                
                     }
              }
              });

              setLayout(new BorderLayout());
              haut.setLayout(new BorderLayout());
              centre3.setVisible(false);
              centre1.add(choix);
              centre1.add(montant);
              centre1.add(euro);
              centre1.add(Payer);
              centre.setLayout(new StackLayout());
              centre2.add(info_solde);
              centre.add(centre1);
              centre.add(centre2);
              centre.add(centre3);
              sud.setLayout(new BorderLayout());
              sud.add(retour,BorderLayout.WEST);
              add(haut,BorderLayout.NORTH);
              add(centre,BorderLayout.CENTER);
              add(sud,BorderLayout.SOUTH);
       }
}