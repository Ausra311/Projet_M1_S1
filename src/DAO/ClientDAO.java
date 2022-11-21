package DAO;

import fc.Client;
import java.sql.Connection;
import java.sql.SQLException;


public class ClientDAO extends DAO<Client> {

    public ClientDAO(Connection conn){
           super(conn);
    }

    @Override
    public boolean create(Client obj, String type) throws SQLException {
        switch (type) {
            case "Sans Carte" :
                
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
