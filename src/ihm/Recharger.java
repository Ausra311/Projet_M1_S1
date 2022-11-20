package ihm;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Recharger extends JPanel {
       JFrame Fenetre;
       Recharger(JFrame f) {
       Fenetre = f;
       JPanel haut = new JPanel();
       JPanel centre = new JPanel();
       JPanel sud = new JPanel();
       JLabel instruction = new JLabel("Le montant de rechargement est de 10€ minimum ");
       JLabel choix = new JLabel("Choix montant :"); 
       JButton Payer = new JButton("Payer");
       JButton retour = new JButton("retour");
       JTextField montant = new JTextField();
       retour.addActionListener(new ActionListener()
       {
              public void actionPerformed(ActionEvent e){
              Fenetre.setContentPane(new GestionCompte(Fenetre));
              Fenetre.revalidate();
              }
       });

       setLayout(new BorderLayout());
       centre.setLayout(new FlowLayout());
       haut.setLayout(new BorderLayout());
       haut.add(instruction,BorderLayout.CENTER);
       centre.add(choix);
       centre.add(montant);
       centre.add(Payer);
       sud.setLayout(new BorderLayout());
       sud.add(retour,BorderLayout.WEST);
       add(haut,BorderLayout.NORTH);
       add(centre,BorderLayout.CENTER);
       add(sud,BorderLayout.SOUTH);
       }

}