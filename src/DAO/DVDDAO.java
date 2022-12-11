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
        Vector<DVD> dv = new Vector<DVD>();
        try (PreparedStatement Resul = conn.prepareStatement("select distinct d.noSupport , d.etat , d.emplacement from DVD d , ((Select d.noSupport from DVD d, Support s where s.nofilm = ? and s.nosupport = d.nosupport) MINUS (Select l.noSupport from Location l, Support s where s.nofilm = ? and s.nosupport = l.nosupport) k where k.noSupport = d.noSupport)")){   
                Resul.setInt(1,((Film)obj).get_id());
                Resul.setInt(2,((Film)obj).get_id());
                ResultSet resultSet = Resul.executeQuery();
                if (resultSet.next()) {
                int nosupport = resultSet.getInt(1);
                String etat = resultSet.getString(2);
                int emplacement = resultSet.getInt(3);
                DVD d = new DVD(nosupport,etat,emplacement);
                dv.add(d);  
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return dv;
    }

    @Override
    public boolean update(DVD obj) throws SQLException {
        try (PreparedStatement Etat = conn.prepareStatement("update DVD Set etat = ? Where noSupport = ?")){
            if (obj.est_endommage()){
                Etat.setInt(2, obj.get_id());
                Etat.setInt(1, "Endommage");
                Etat.executeQuery();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(DVD obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }
}
