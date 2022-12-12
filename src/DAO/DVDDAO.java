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
           Vector<DVD> D = new Vector<DVD>();
           Film f = (Film) obj;
           try (PreparedStatement Info_support = conn.prepareStatement(("(Select noSupport from Support S where noFilm = ?) MINUS (Select noSupport from Location where retourne = 0)"));
                PreparedStatement Info_DVD = conn.prepareStatement("Select * from DVD where nosupport = ?")){
           
                ResultSet support, dvd;
                Info_support.setInt(1, f.get_id());
                support = Info_support.executeQuery();

                while (support.next()){
                    Info_DVD.setInt(1, support.getInt(1));
                    dvd = Info_DVD.executeQuery();
                    
                    if (dvd.next()){
                        if (dvd.getString(2) == "Bon"){
                            D.add(new DVD(f, dvd.getInt(3), false, true, dvd.getInt(1)));
                            
                        } else {
                            D.add(new DVD(f, dvd.getInt(3), true, true, dvd.getInt(1)));
                        }
                    }
                }
           }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return D;
    }

    @Override
    public boolean update(DVD obj) throws SQLException {
        try (PreparedStatement Etat = conn.prepareStatement("update DVD Set etat = ? Where noSupport = ?")){
            if (obj.est_endommage()){
                Etat.setInt(2, obj.get_id());
                Etat.setString(1, "Endommage");
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
