package DAO;

import fc.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ClientDAO extends DAO<Client> {

    public ClientDAO(Connection conn){
           super(conn);
    }

    @Override
    public boolean create(Client obj, String type) throws SQLException {
        switch (type) {
            case "Sans Carte" :
                try (PreparedStatement Client = conn.prepareStatement("INSERT INTO CLIENT VALUES (?, ?)");
                    PreparedStatement CarteBanquaire = conn.prepareStatement("INSERT INTO CarteBancaire VALUES (?, ?, ?, ?, SYSDATE)")) {
                    Client.setInt(1, obj.getId());
                    CarteBanquaire.setInt(1, obj.getId());
                    CarteBanquaire.setInt(1, obj.getId());
                    CarteBanquaire.setInt(1, obj.getId());
                    CarteBanquaire.setInt(1, obj.getId());
        
                    Boolean b = Client.executeUpdate() > 0;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            break;
            case "Abonne Parent" :

            break;
            case "Abonne Enfant" :

            break;
            default :
            break;
        }
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Client read(Object obj) throws SQLException {
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
