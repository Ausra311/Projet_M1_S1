package DAO;

import fc.QRCode;
import java.sql.Connection;
import java.sql.SQLException;

public class QRCodeDAO extends DAO<QRCode>{
    
    public QRCodeDAO(Connection conn) {
		super(conn);
	}

    @Override
    public boolean create(QRCode obj, String type) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public QRCode read(Object obj) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(QRCode obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(QRCode obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }
}
