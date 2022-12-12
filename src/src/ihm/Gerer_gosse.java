package ihm;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import fc.*;

import java.awt.*;

public class Gerer_gosse extends JPanel {
    JFrame Fenetre;
    Interface inter;
    Gerer_gosse(JFrame j, Interface i,Film film){
        inter = i;
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
        ages.add("10");
        ages.add("12");
        ages.add("16");
        ages.add("18");
        ages.add("aucune");
        enfants.add("-- Choix du compte--");
        enfants.add("enfant 1");
        enfants.add("enfant 2");
        JButton ajouterRes = new JButton("Ajouter cette restriction");
        JButton supprimer = new JButton("Supprimer cette restriction");
        ajouterRes.setVisible(false);
        supprimer.setVisible(false);
        JComboBox Liste_enfants = new JComboBox<>(enfants);
        ArrayList<String> Restriction_actuelle = new ArrayList<String>();
        Liste_enfants.setFont(new Font("Arial",Font.BOLD,25));
        
        Vector<String> genre = new Vector<String>();
        genre.add("Choisir Restriction");
        genre.add("Action");
        genre.add("Animation");
        JComboBox Liste_genre = new JComboBox<>(genre);
        Liste_genre.setFont(new Font("Arial",Font.BOLD,25));
        Liste_genre.addActionListener(event ->{
            ajouterRes.setVisible(false);
            supprimer.setVisible(false);
            if(Liste_genre.getSelectedItem() == "Choisir Restriction"){}
            else if(Restriction_actuelle.contains(Liste_genre.getSelectedItem())){
                supprimer.setVisible(true);
            }else{
                ajouterRes.setVisible(true);
            }
        });
        Liste_enfants.addActionListener(event ->{
            centre0.removeAll();
            centre1.removeAll();
            centre2.removeAll();
            centre3.removeAll();
            ajouterRes.setVisible(false);
            supprimer.setVisible(false);

            Liste_genre.setSelectedIndex(0);
            Restriction_actuelle.removeAll(Restriction_actuelle);
            Restriction_actuelle.add("Action");
            JLabel choix_age = new JLabel("Choisir restriction d'âge :");
            choix_age.setFont(new Font("Arial",Font.BOLD,25));
            JComboBox res_age = new JComboBox<>(ages);
            res_age.setFont(new Font("Arial",Font.BOLD,25));
            JComboBox comboBox1 = (JComboBox) event.getSource();
            comboBox1.setFont(new Font("Arial",Font.BOLD,25));
            String nom = (String) comboBox1.getSelectedItem();
            JLabel name = new JLabel(nom);
            name.setFont(new Font("Arial",Font.BOLD,25));
            JButton valider = new JButton("Valider");
            valider.setFont(new Font("Arial",Font.BOLD,25));
            valider.addActionListener(new ActionListener()
            {
            public void actionPerformed(ActionEvent e){
                System.out.println("Nouvelle restriction d'age : " + res_age.getSelectedItem() + " ans");
                }
            });
            int age = 10;
            JLabel restr_age = new JLabel("Restriction d'âge actuelle : " + age);
            restr_age.setFont(new Font("Arial",Font.BOLD,25));
            JLabel restr_genre = new JLabel("Restrictions de genre actuelles : " + Restriction_actuelle);
            restr_genre.setFont(new Font("Arial",Font.BOLD,25));
            ajouterRes.setFont(new Font("Arial",Font.BOLD,25));
            supprimer.setFont(new Font("Arial",Font.BOLD,25));

            centre0.add(name);
            centre1.add(restr_age);
            centre2.add(choix_age);
            centre2.add(res_age);
            centre2.add(valider);
            centre3.add(restr_genre);
            centre4.add(Liste_genre);
            centre4.add(ajouterRes);
            centre4.add(supprimer);
            centre.setVisible(true);
            revalidate();
            

        });


        JButton Retour = new JButton("Retour");
        Retour.setPreferredSize(new Dimension(110,50));
        Retour.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new GestionCompte(Fenetre,inter,film));
            Fenetre.revalidate();
            }
        });


        ajouterRes.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            System.out.println(Liste_genre.getSelectedItem()+ " ajouté de la liste des restictions");
            }
        });

        supprimer.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            System.out.println(Liste_genre.getSelectedItem()+ " supprimé de la liste des restictions");
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
