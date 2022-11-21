
package DAO;
import fc.Abonne_enfant;
import java.sql.Connection;
import java.sql.SQLException;


public class AbonneEnfantDAO extends DAO<Abonne_enfant> {

    public AbonneEnfantDAO(Connection conn){
           super(conn);
    }

    @Override
    public boolean create(Abonne_enfant obj, String type) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Abonne_enfant read(Object obj) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Abonne_enfant obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Abonne_enfant obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

 
    
}

