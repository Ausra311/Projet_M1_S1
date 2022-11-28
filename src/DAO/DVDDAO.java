package DAO;

import fc.DVD;
import fc.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

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
    public Vector<DVD> read(Object obj) throws SQLException {
           DVD dvd = null;
           try (PreparedStatement Resul = conn.prepareStatement("select distinct d.noSupport , d.etat , d.emplacement from DVD d , ((Select d.noSupport from DVD d, Support s where s.nofilm = ? and s.nosupport = d.nosupport) MINUS (Select l.noSupport from Location l, Support s where s.nofilm = ? and s.nosupport = l.nosupport) k where k.noSupport = d.noSupport)")){   
                 Resul.setInt(1,((Film)obj).get_id());
                 Resul.setInt(2,((Film)obj).get_id());
                 ResultSet resultSet = Resul.executeQuery();
                 
           }
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
