
package ihm;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class Film extends JPanel{
    JFrame Fenetre;
    Film(int id,JFrame j) {
    Fenetre = j;
    JTextField resume;
    JButton Louer = new JButton("Louer");
    JLabel titre = new JLabel("KiKi");
    JLabel dispoDVD = new JLabel("Disponible en DVD uniquement");
    JLabel dispoQR = new JLabel("Disponible en QR code uniquement");
    JLabel dispo = new JLabel("Disponible en DVD et QR code");
    switch(id){
        case 1 :
            resume = new JTextField("Kiki \n C'est une sorciere");
            break;
        case 2 :
            resume = new JTextField("Kiki \n C'est presque une sorciere");
        break;
        default:
            resume = new JTextField();
        break;
    }
    ImageIcon img = new ImageIcon("kiki.jpg");
    JLabel image = new JLabel(img);
    image.setIcon((Icon) img);
    Louer.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            Fenetre.setContentPane(new FicheFilm(0,Fenetre));
            Fenetre.revalidate();
            }
        });

    setLayout(new BorderLayout());
    add(image,BorderLayout.WEST);
    add(Louer,BorderLayout.EAST);
    add(resume,BorderLayout.CENTER);
    }

}