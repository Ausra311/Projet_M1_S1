package ihm;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Recharger extends JPanel {
       JFrame Fenetre;
       int pred;
       Recharger(JFrame f, int i) {
              Fenetre = f;
              pred = i;

              JPanel haut = new JPanel();
              haut.setPreferredSize(new Dimension(600,400));
              JPanel centre = new JPanel();
              JPanel sud = new JPanel();
              JLabel choix = new JLabel("Choix montant (10 euros minimum): "); 
              JLabel euro = new JLabel("€");
              JButton Payer = new JButton("Payer");
              JButton retour = new JButton("Retour");
              JTextField montant = new JTextField();

              montant.setPreferredSize(new Dimension(100,50));
              Payer.setPreferredSize(new Dimension(150,50));
              choix.setPreferredSize(new Dimension(275,50));
              euro.setPreferredSize(new Dimension(15,50));
              choix.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
              montant.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
              euro.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
              Payer.setFont(new Font("Arial",Font.CENTER_BASELINE,15));

              retour.setPreferredSize(new Dimension(110,50));
              retour.addActionListener(new ActionListener()
              {
                     public void actionPerformed(ActionEvent e){
                     if(pred==0){
                            Fenetre.setContentPane(new GestionCompte(Fenetre));
                            Fenetre.revalidate();
                     }else{
                            Fenetre.setContentPane(new Louer_abo(Fenetre,true));
                            Fenetre.revalidate();                
                     }
              }
              });

              setLayout(new BorderLayout());
              haut.setLayout(new BorderLayout());

              centre.add(choix);
              centre.add(montant);
              centre.add(euro);
              centre.add(Payer);
              sud.setLayout(new BorderLayout());
              sud.add(retour,BorderLayout.WEST);
              add(haut,BorderLayout.NORTH);
              add(centre,BorderLayout.CENTER);
              add(sud,BorderLayout.SOUTH);
       }
}