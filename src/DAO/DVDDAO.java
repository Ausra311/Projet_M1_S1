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
<<<<<<< HEAD
    public Vector<DVD> read(Object obj) throws SQLException {
           DVD dvd = null;
           Vector<DVD> dv = new Vector<DVD>();
           Film f = (Film) obj;
           try (PreparedStatement Resul = conn.prepareStatement("select distinct d.noSupport , d.etat , d.emplacement from DVD d , ((Select d.noSupport from DVD d, Support s where s.nofilm = ? and s.nosupport = d.nosupport) MINUS (Select l.noSupport from Location l, Support s where s.nofilm = ? and s.nosupport = l.nosupport) k where k.noSupport = d.noSupport)")){   
                 Resul.setInt(1,f.get_id());
                 Resul.setInt(2,f.get_id());
                 ResultSet resultSet = Resul.executeQuery();
                 if (resultSet.next()) {
                    int nosupport = resultSet.getInt(1);
                    String etat = resultSet.getString(2);
                    int emplacement = resultSet.getInt(3);
                    Boolean b = Boolean.valueOf(etat);
                    dvd = new DVD(f, emplacement,b,true,nosupport);
                    dv.add(dvd);  
                }
           }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return dv;
=======
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
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04
    }

    @Override
    public boolean update(DVD obj) throws SQLException {
        try (PreparedStatement Etat = conn.prepareStatement("update DVD Set etat = ? Where noSupport = ?")){
            if (obj.est_endommage()){
                Etat.setInt(2, obj.get_id());
<<<<<<< HEAD
                Etat.setString(1, "Endommage");
=======
                Etat.setInt(1, "Endommage");
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04
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
