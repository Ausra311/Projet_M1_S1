
package DAO;

import fc.Location;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;



public class LocationDAO extends DAO<Location> {

    public LocationDAO(Connection conn){
           super(conn);
    }

    @Override
    public boolean create(Location obj, String type) throws SQLException {
        try (PreparedStatement Location = conn.prepareStatement("INSERT INTO Location VALUES (?, ? , ? , 0)")) {
            Location.setInt(1, obj.get_client().get_id());
            Location.setInt(2, obj.get_support());
            Location.setDate(3, obj.date_emprunt());

            Location.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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

