package DAO;

import fc.Carte_banquaire;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public class Carte_BancaireDAO extends DAO<Carte_banquaire>{
    
    public Carte_BancaireDAO(Connection conn) {
		super(conn);
	}

    @Override
    public boolean create(Carte_banquaire obj, String type) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Vector<Carte_banquaire> read(Object obj) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Carte_banquaire obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Carte_banquaire obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }


}
