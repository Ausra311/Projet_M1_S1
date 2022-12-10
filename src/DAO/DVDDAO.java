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
    public Vector<Abonne_enfant> read(Object obj) throws SQLException {
        Abonne_enfant abonne_enfant = null;
        String nom = null;
        String prenom = null;
        String adresse =null;
        String telephone = null;
        int solde = (Integer) null;
        Carte_banquaire carte = null;
        
        Vector<Abonne_enfant> ab = new Vector<Abonne_enfant>();

        try (PreparedStatement Resul = conn.prepareStatement("select noClient  , restrictionAge from AbonneEnfant where noParent = ?  ")){   
            Resul.setInt(1,((Client)obj).get_id());
            ResultSet resultSet = Resul.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                abonne_enfant = new  Abonne_enfant(id,nom,prenom,adresse,telephone,solde,carte); 
                abonne_enfant.add_restriction_age(resultSet.getInt(3));
                ab.add(abonne_enfant);  
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return ab;
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
