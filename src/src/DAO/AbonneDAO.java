package DAO;

import fc.Abonne;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        // TODO Auto-generated method stub
        return null;
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
