
package DAO;

import fc.Location;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.PreparedStatement;



public class LocationDAO extends DAO<Location> {

    public LocationDAO(Connection conn){
           super(conn);
    }

    @Override
    public boolean create(Location obj, String type) throws SQLException {
        try (PreparedStatement Location = conn.prepareStatement("INSERT INTO Location VALUES (?, ? , ? , 0)")) {
<<<<<<< HEAD
            Location.setInt(1, obj.get_Client().get_id());
            Location.setInt(2, obj.get_Support().get_id());
            Location.setDate(3, (java.sql.Date) obj.date_emprunt());
=======
            Location.setInt(1, obj.get_client().get_id());
            Location.setInt(2, obj.get_support());
            Location.setDate(3, obj.date_emprunt());
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04

            Location.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Vector<Location> read(Object obj) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Location obj) throws SQLException {
        try (PreparedStatement Etat = conn.prepareStatement("update Loaction Set retourne = 1 and dateRetour = ? Where noClient = ? and noSupport = ? and dateEmprunt = ?")){
<<<<<<< HEAD
            if (obj.get_Support().est_endommage()){
                Etat.setInt(2, obj.get_Client().get_id());
                Etat.setString(1, "Endommage");
=======
            if (obj.est_endommage()){
                Etat.setInt(2, obj.get_id());
                Etat.setInt(1, "Endommage");
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04
                Etat.executeQuery();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Location obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }
    
    
}

