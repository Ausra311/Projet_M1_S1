package DAO;

import fc.Abonne;
import java.sql.Connection;
<<<<<<< HEAD
import java.sql.PreparedStatement;
=======
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04
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
<<<<<<< HEAD
        // TODO Auto-generated method stub
        return null;
=======
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
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04
    }

    @Override
    public boolean update(Abonne obj) throws SQLException {
        try (PreparedStatement req_client = conn.prepareStatement("update Client Set typeClient = 'Abonne Parent' where noClient = ?");
            PreparedStatement nv_parent = conn.prepareStatement("Insert into AbonneParent value ( ?, 0)");
            PreparedStatement suppr_enfant = conn.prepareStatement("Delete AbonneEnfant where noClient = ?");
            PreparedStatement suppr_restriction = conn.prepareStatement("Delete Restriction where noClient = ?")){
            
            req_client.setInt(1, obj.get_id());
            nv_parent.setInt(1, obj.get_id());
            suppr_enfant.setInt(1, obj.get_id());
            suppr_restriction.setInt(1, obj.get_id());

            req_client.executeQuery();
            nv_parent.executeQuery();
            suppr_enfant.executeQuery();
            suppr_restriction.executeQuery();  
<<<<<<< HEAD
=======
            }
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Abonne obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }
    
}
