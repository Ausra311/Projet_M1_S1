
package ihm;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class Film extends JPanel{
    JFrame Fenetre;
    boolean connecter;
    Film(int id,JFrame j,boolean c) {
    connecter =c;
    Fenetre = j;
    JTextField resume;
    JButton Louer = new JButton("Louer");
    Louer.setPreferredSize(new Dimension(105,40));
    JLabel titre = new JLabel("KiKi");
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
            Fenetre.setContentPane(new FicheFilm(0,Fenetre,connecter));
            Fenetre.revalidate();
            }
        });

    setLayout(new BorderLayout());
    add(image,BorderLayout.WEST);
    add(Louer,BorderLayout.EAST);
    add(resume,BorderLayout.CENTER);
    }
}