package ihm;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;

public class Gerergosse extends JPanel {
    JFrame Fenetre;
    Gerergosse(JFrame j){
        Fenetre = j;
        JPanel centre = new JPanel();
        JPanel centre0 = new JPanel();
        JPanel centre1 = new JPanel();
        JPanel centre2 = new JPanel();
        JPanel centre3 = new JPanel();
        JPanel centre4 = new JPanel();
        JPanel sud = new JPanel();
        JPanel nord = new JPanel();
        nord.setPreferredSize(new Dimension(1200,70));
        centre0.setPreferredSize(new Dimension(1200,70));
        centre1.setPreferredSize(new Dimension(1200,70));
        centre2.setPreferredSize(new Dimension(1200,70));
        centre3.setPreferredSize(new Dimension(1200,70));
        centre4.setPreferredSize(new Dimension(1200,70));
        Vector<String> enfants = new Vector<String>();
        Vector<String> ages = new Vector<String>();
        JButton ajouter = new JButton("Ajouter");
        JLabel temp = new JLabel("Selection des genres a définir");
        ages.add("10");
        ages.add("12");
        ages.add("16");
        ages.add("18");
        ages.add("aucune");
        enfants.add("-- Choix du compte--");
        enfants.add("enfant 1");
        enfants.add("enfant 2");
        JComboBox Liste_enfants = new JComboBox<>(enfants);
        Liste_enfants.addActionListener(event ->{
            centre0.removeAll();
            centre1.removeAll();
            centre2.removeAll();
            centre3.removeAll();

            JLabel choix_age = new JLabel("Choisir restriction d'âge :");
            JComboBox res_age = new JComboBox<>(ages);
            JComboBox comboBox1 = (JComboBox) event.getSource();
            String nom = (String) comboBox1.getSelectedItem();
            JLabel name = new JLabel(nom);
            JButton valider = new JButton("Valider");
            int age = 10;
            JLabel restr_age = new JLabel("Restriction d'âge actuelle : " + age);
            JLabel restr_genre = new JLabel("Restrictions de genre actuelles : Action");

            centre0.add(name);
            centre1.add(restr_age);
            centre2.add(choix_age);
            centre2.add(res_age);
            centre2.add(valider);
            centre3.add(restr_genre);
            centre4.add(temp);
            centre4.add(ajouter);
            centre.setVisible(true);
            revalidate();
            

        });


        JButton Retour = new JButton("Retour");
        Retour.setPreferredSize(new Dimension(110,50));
        Retour.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new GestionCompte(Fenetre));
            Fenetre.revalidate();
            }
        });
        centre.setLayout(new StackLayout());


        centre.add(centre0);
        centre.add(centre1);
        centre.add(centre2);
        centre.add(centre3);
        centre.add(centre4);
        centre.setVisible(false);
        sud.setLayout(new BorderLayout());
        sud.add(Retour,BorderLayout.WEST);
        nord.add(Liste_enfants);
        setLayout(new BorderLayout());
        add(nord,BorderLayout.NORTH);
        add(centre,BorderLayout.CENTER);
        add(sud,BorderLayout.SOUTH);

    }
}
