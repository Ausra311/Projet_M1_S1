package DAO;

import fc.Abonne_parent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public class AbonneParentDAO extends DAO<Abonne_parent>{
    
    public AbonneParentDAO(Connection conn) {
		super(conn);
	}

    @Override
    public boolean create(Abonne_parent obj, String type) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Vector<Abonne_parent> read(Object obj) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Abonne_parent obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Abonne_parent obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

}
