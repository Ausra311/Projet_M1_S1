package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class GenreDAO extends DAO<String> {

    public GenreDAO(Connection conn){
        super(conn);
    }

    @Override
    public boolean create(String obj, String type) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Vector<String> read(Object obj) throws SQLException {
        Vector<String> Genre = new Vector<String>();
        try (PreparedStatement req = conn.prepareStatement("Select * from TypeGenre")){
            ResultSet res = req.executeQuery();
            while (res.next()) {
                Genre.add(res.getString(1));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(String obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(String obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }
}