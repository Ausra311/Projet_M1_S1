package DAO;

<<<<<<< HEAD
import fc.Abonne_enfant;
=======
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04
import fc.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;


public class ClientDAO extends DAO<Client> {

    public ClientDAO(Connection conn){
           super(conn);
    }

    @Override
    public boolean create(Client obj, String type) throws SQLException {
        switch (type) {
            case "Sans Carte" :
                try (PreparedStatement Client = conn.prepareStatement("INSERT INTO CLIENT VALUES (?, 'Sans Carte')");
                    PreparedStatement CarteBanquaire = conn.prepareStatement("INSERT INTO CarteBancaire VALUES (?, ?, ?, ?, SYSDATE)")) {
                    Client.setInt(1, obj.get_id());
                    CarteBanquaire.setInt(1, obj.get_id());
                    CarteBanquaire.setString(2, obj.get_cb().get_nom());
                    CarteBanquaire.setString(3, obj.get_cb().get_type_carte());
<<<<<<< HEAD
                    CarteBanquaire.setString(4, obj.get_cb().get_reference());
=======
                    CarteBanquaire.setInt(4, obj.get_cb().get_reference());
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04
        
                    Boolean b = Client.executeUpdate() > 0;
                    if(b){
                        CarteBanquaire.executeUpdate();
                    }
                    
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "Abonne Parent" :
                try (PreparedStatement Client = conn.prepareStatement("INSERT INTO CLIENT VALUES (?, 'Abonne Parent')");
                PreparedStatement Abonne = conn.prepareStatement("INSERT INTO ABONNE VALUES (?, ?, ?, ?, ?, ?)"); 
                PreparedStatement Parent = conn.prepareStatement("INSERT INTO ABONNEPARENT VALUES (?, 0)")) {
                Client.setInt(1, obj.get_id());
                Abonne.setInt(1, obj.get_id());
                Abonne.setString(2, obj.get_nom());
                Abonne.setString(3, obj.get_prenom());
<<<<<<< HEAD
                Abonne.setString(4, obj.get_adresse());
                Abonne.setString(5, obj.get_telephone());
=======
                Abonne.setInt(4, obj.get_addresse());
                Abonne.setInt(5, obj.get_telephone());
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04
                Abonne.setInt(6, obj.get_solde());
                Parent.setInt(1, obj.get_id());

                Boolean b = Client.executeUpdate() > 0;
                if(b){
                    Abonne.executeUpdate();
                    Parent.executeUpdate();
                }
                
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "Abonne Enfant" :
                try (PreparedStatement Client = conn.prepareStatement("INSERT INTO CLIENT VALUES (?, 'Abonne Enfant')");
                PreparedStatement Abonne = conn.prepareStatement("INSERT INTO ABONNE VALUES (?, ?, ?, ?, ?, ?)"); 
                PreparedStatement Enfant = conn.prepareStatement("INSERT INTO ABONNEENFANT VALUES (?, ?, ?)")) {
                Client.setInt(1, obj.get_id());
                Abonne.setInt(1, obj.get_id());
                Abonne.setString(2, obj.get_nom());
                Abonne.setString(3, obj.get_prenom());
<<<<<<< HEAD
                Abonne.setString(4, obj.get_adresse());
                Abonne.setString(5, obj.get_telephone());
                Abonne.setInt(6, obj.get_solde());
                Enfant.setInt(1, obj.get_id());
                Enfant.setInt(2, obj.get_id()); 
                Enfant.setInt(3, ((Abonne_enfant) obj).get_age());
=======
                Abonne.setInt(4, obj.get_addresse());
                Abonne.setInt(5, obj.get_telephone());
                Abonne.setInt(6, obj.get_solde());
                Enfant.setInt(1, obj.get_id());
                Enfant.setInt(2, obj.get_id_parent()); /// A voir le nom de la fonction
                Enfant.setInt(3, obj.get_age());
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04


                Boolean b = Client.executeUpdate() > 0;
                if(b){
                    Abonne.executeUpdate();
                    Enfant.executeUpdate();
                }
                
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default :
                break;
        }
        return false;
    }

    @Override
    public Vector<Client> read(Object obj) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Client obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Client obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }
    
}
