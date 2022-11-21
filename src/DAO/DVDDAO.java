package DAO;

import fc.DVD;
import java.sql.Connection;
import java.sql.SQLException;

public class DVDDAO extends DAO<DVD>{
    
    public DVDDAO(Connection conn) {
		super(conn);
	}

    @Override
    public boolean create(DVD obj, String type) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public DVD read(Object obj) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(DVD obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(DVD obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }
}
