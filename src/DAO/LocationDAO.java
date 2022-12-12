
package DAO;

import fc.Location;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.Vector;
import java.sql.PreparedStatement;
//import java.util.Calendar;
//import java.util.Date;
import java.sql.Date;


public class LocationDAO extends DAO<Location> {

    public LocationDAO(Connection conn){
           super(conn);
    }

    @Override
    public boolean create(Location obj, String type) throws SQLException {
        //java.sql.Date d = new java.sql.Date(obj.date_emprunt().getTime());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try (PreparedStatement Location = conn.prepareStatement("INSERT INTO Location VALUES (?, ? , ? , 0)")) {
            Location.setInt(1, obj.get_Client().get_id());
            Location.setInt(2, obj.get_Support().get_id());
            //Location.setDate(3, d);
           java.sql.Date date1 = java.sql.Date.valueOf((dateFormat.format(obj.date_emprunt())));
            Location.setDate(3,date1);
           
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
            //Etat.setDate(1, obj.date_rendu());
            Etat.setInt(12, obj.get_Client().get_id());
            Etat.setInt(3, obj.get_Support().get_id());
            //Etat.setDate(4, obj.date_emprunt());

            Etat.executeUpdate();
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

