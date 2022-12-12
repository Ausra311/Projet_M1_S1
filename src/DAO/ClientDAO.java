package DAO;

import fc.Abonne_enfant;
import fc.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            System.out.println("OK");
                try (PreparedStatement Client = conn.prepareStatement("INSERT INTO CLIENT VALUES (?, 'Sans Carte')");
                    PreparedStatement CarteBanquaire = conn.prepareStatement("INSERT INTO CarteBancaire VALUES (?, ?, ?, ?, SYSDATE)")) {
                    Client.setInt(1, obj.get_id());
                    CarteBanquaire.setInt(1, obj.get_id());
                    CarteBanquaire.setString(2, obj.get_cb().get_nom());
                    CarteBanquaire.setString(3, obj.get_cb().get_type_carte());
                    CarteBanquaire.setString(4, obj.get_cb().get_reference());
        
                    ResultSet res1 = Client.executeQuery();
                    if(res1.next()){
                        CarteBanquaire.executeQuery();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "Abonne Parent" :
            System.out.println("OK");

                try (PreparedStatement Client = conn.prepareStatement("INSERT INTO CLIENT VALUES (?, 'Abonne Parent')");
                PreparedStatement Abonne = conn.prepareStatement("INSERT INTO ABONNE VALUES (?, ?, ?, ?, ?, ?)"); 
                PreparedStatement Parent = conn.prepareStatement("INSERT INTO ABONNEPARENT VALUES (?, 0)")) {
                    Client.setInt(1, obj.get_id());
                    Abonne.setInt(1, obj.get_id());
                    Abonne.setString(2, obj.get_nom());
                    Abonne.setString(3, obj.get_prenom());
                    Abonne.setString(4, obj.get_adresse());
                    Abonne.setString(5, obj.get_telephone());
                    Abonne.setInt(6, obj.get_solde());
                    Parent.setInt(1, obj.get_id());

                    ResultSet res1 = Client.executeQuery();
                    if(res1.next()){
                        Abonne.executeQuery();
                        Parent.executeQuery();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "Abonne Enfant" :
            System.out.println("OK");

                try (PreparedStatement Client = conn.prepareStatement("INSERT INTO CLIENT VALUES (?, 'Abonne Enfant')");
                PreparedStatement Abonne = conn.prepareStatement("INSERT INTO ABONNE VALUES (?, ?, ?, ?, ?, ?)"); 
                PreparedStatement Enfant = conn.prepareStatement("INSERT INTO ABONNEENFANT VALUES (?, ?, ?)")) {
                    Client.setInt(1, obj.get_id());
                    Abonne.setInt(1, obj.get_id());
                    Abonne.setString(2, obj.get_nom());
                    Abonne.setString(3, obj.get_prenom());
                    Abonne.setString(4, obj.get_adresse());
                    Abonne.setString(5, obj.get_telephone());
                    Abonne.setInt(6, obj.get_solde());
                    Enfant.setInt(1, obj.get_id());
                    Enfant.setInt(2, obj.get_id()); 
                    Enfant.setInt(3, ((Abonne_enfant) obj).get_age());

                    ResultSet res1 = Client.executeQuery();
                    if(res1.next()){
                        Abonne.executeQuery();
                        Enfant.executeQuery();
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

    public String type(int id) throws SQLException {
        String type = null;
        try (PreparedStatement req = conn.prepareStatement("Select Type from Client where noClient = ?")){
            req.setInt(1, id);
            ResultSet res = req.executeQuery();
            if (res.next()){
                type = res.getString(1);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }
    
}
