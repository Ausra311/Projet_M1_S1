package DAO;

import fc.Abonne;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public class AbonneDAO extends DAO<Abonne>{

    public AbonneDAO(Connection conn) {
		super(conn);
	}

    @Override
    public boolean create(Abonne obj, String type) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
        public Vector<Abonne> read(Object obj) throws SQLException {
        Abonne abonne = null;
        Carte_banquaire carte = null;
        Vector<Abonne> ab = new Vector<Abonne>();
        try (PreparedStatement Resul = conn.prepareStatement("select noClient , nomAbonne , prenomAbonne , adAbonne , noTel , solde from Abonne where noClient = ?  ")){   
            Resul.setInt(1,((Abonne)obj).get_no_abonne());
            ResultSet resultSet = Resul.executeQuery();
            if (resultSet.next()) {
                int noclient = resultSet.getInt(1);
                String nomabonne = resultSet.getString(2);
                String prenomabonne = resultSet.getString(3);
                String adabonne = resultSet.getString(4);
                String notel = resultSet.getString(5);
                String solde = resultSet.getString(5);
                abonne = new Abonne(noclient,nomabonne,prenomabonne,adabonne,notel,solde,carte);
                ab.add(abonne);  
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return ab;
    }

    @Override
    public boolean update(Abonne obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Abonne obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }
    
}
