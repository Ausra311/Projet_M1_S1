
package DAO;

import fc.Location;
import java.sql.Connection;
import java.sql.SQLException;


public class LocationDAO extends DAO<Location> {

    public LocationDAO(Connection conn){
           super(conn);
    }

    @Override
    public boolean create(Location obj, String type) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Location read(Object obj) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Location obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Location obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }
    
    
}

