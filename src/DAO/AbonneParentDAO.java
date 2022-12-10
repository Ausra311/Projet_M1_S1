package DAO;

import fc.Abonne_parent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public class AbonneParentDAO extends DAO<Abonne_parent>{
    
    public AbonneParentDAO(Connection conn) {
		super(conn);
	}

    @Override
    public boolean create(Abonne_parent obj, String type) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Vector<Abonne_parent> read(Object obj) throws SQLException {
        Abonne_parent abonne_parent = null;
        String nom = null;
        String prenom = null;
        String adresse =null;
        String telephone = null;
        int solde = (Integer) null;
        Carte_banquaire carte = null;
       
        Vector<Abonne_parent> ab = new Vector<Abonne_parent>();

        try (PreparedStatement Resul = conn.prepareStatement("select noClient  , nbEnfant from AbonneParent where noClient = ?  ")){   
                Resul.setInt(1,((Client)obj).get_id());
                ResultSet resultSet = Resul.executeQuery();
                if (resultSet.next()) {
                int id = resultSet.getInt(1);
                abonne_parent = new  Abonne_parent(id,nom,prenom,adresse,telephone,solde,carte); 
                abonne_parent.add_restriction_age(resultSet.getInt(2));
                ab.add(abonne_parent);  
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return ab;
    }

    @Override
    public boolean update(Abonne_parent obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Abonne_parent obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

}
