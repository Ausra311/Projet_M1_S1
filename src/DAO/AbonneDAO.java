package DAO;

import fc.Abonne;
import java.sql.Connection;
import java.sql.SQLException;

public class AbonneDAO extends DAO<Abonne>{

    public AbonneDAO(Connection conn) {
		super(conn);
	}

    @Override
    public boolean create(Abonne obj, String type) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Abonne read(Object obj) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Abonne obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Abonne obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }
    
}
