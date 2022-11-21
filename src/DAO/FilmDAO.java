package DAO;

import fc.Film;
import java.sql.Connection;
import java.sql.SQLException;

public class FilmDAO extends DAO<Film> {

    public FilmDAO(Connection conn){
           super(conn);
    }

    @Override
    public boolean create(Film obj, String type) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Film read(Object obj) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Film obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Film obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }
    
    
}

