package DAO;

import fc.Support;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public class SupportDAO extends DAO<Support>{
    
    public SupportDAO(Connection conn) {
		super(conn);
	}

    @Override
    public boolean create(Support obj, String type) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Vector<Support> read(Object obj) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Support obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Support obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }
}