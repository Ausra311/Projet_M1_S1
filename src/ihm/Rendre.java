package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import fc.*;


public class Rendre extends JPanel {
    boolean connecter;
    Interface inter;
    Automate auto = new Automate();
    boolean casser = false;

    Rendre(JFrame f,boolean c,Interface i){
        inter =i;
        JFrame Fenetre = f;
        connecter =c;

        JPanel sud = new JPanel();
        JPanel centre = new JPanel();
        JPanel centre1 = new JPanel(); 
        JPanel centre2 = new JPanel();
        JPanel centre3 = new JPanel();
        JButton Valider = new JButton("Valider");
        JButton Retour = new JButton("Retour");
        JCheckBox checkBox = new JCheckBox("Déclarer comme endommagé");
        JLabel Message = new JLabel("Inserez le DVD à rendre");
        JLabel espace = new JLabel("");


        setLayout(new BorderLayout());
        centre.setLayout(new StackLayout());

        JPanel haut = new JPanel(); 
        haut.setPreferredSize(new Dimension(600,400));
        checkBox.setPreferredSize(new Dimension(400,60));
        checkBox.setFont(new Font("Arial",Font.ROMAN_BASELINE,25));
        checkBox.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
            casser =true;
        } else {//checkbox has been deselected
            casser = false;
                };
            }
        });
        Message.setFont(new Font("Arial",Font.BOLD,25));
        Valider.setPreferredSize(new Dimension(400,60));
        Valider.setFont(new Font("Arial",Font.BOLD,25));
        Retour.setPreferredSize(new Dimension(110,50));
        Retour.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Accueil(Fenetre,connecter,inter));
            Fenetre.revalidate();
            }
        });
        Valider.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new Accueil(Fenetre,connecter,inter));
            inter.rendre(casser);
            Fenetre.revalidate();
            }
        });

        centre1.add(Message);
        centre.add(centre1);
        centre.add(espace);
        centre2.add(checkBox);
        centre.add(centre2);
        centre.add(espace);
        centre3.add(Valider);
        centre.add(centre3);

        sud.setLayout(new BorderLayout());
        sud.add(Retour,BorderLayout.WEST);

        //Panel principal
        add(centre,BorderLayout.CENTER);
        add(sud,BorderLayout.SOUTH);
        add(haut,BorderLayout.NORTH);
    }
}
