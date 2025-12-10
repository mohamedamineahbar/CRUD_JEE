package Dao;

import Db.Db;
import model.Livre;
import java.sql.*;
import java.util.*;


public class LivreServices {

    public static void addLivre(Livre l) {
        if(getLivreByref(l.getRef())!=null) {
            System.out.println("le livre est deja exsiste");
            return ;
        }
        String Query = "INSERT INTO Livres(ref,title,prix,qte) VALUES (?,?,?,?)";
        try(Connection conn = Db.getConn();
            PreparedStatement stm = conn.prepareStatement(Query)){
            stm.setString(1,l.getRef());
            stm.setString(2,l.getTitle());
            stm.setDouble(3,l.getPrix());
            stm.setInt(4, l.getQte());
            stm.executeUpdate();
            System.out.println("le livre a ete ajoute");
            stm.close();
            conn.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static Livre getLivreByref(String ref) {
        String Query = "SELECT * FROM Livres WHERE ref = ?";
        try(Connection conn = Db.getConn();
            PreparedStatement stm = conn.prepareStatement(Query)){
            stm.setString(1, ref);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
                return new Livre(rs.getString("ref"),rs.getString("title"),rs.getDouble("prix"),rs.getInt("qte"));
            }else {
                return null;
            }
        }catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void deleteLivreByref(String ref) {
        if(getLivreByref(ref)==null) {
            return ;
        }
        String Query = "DELETE FROM Livres WHERE ref = ?";
        try(Connection conn = Db.getConn();
            PreparedStatement stm = conn.prepareStatement(Query)){
            stm.setString(1, ref);
            stm.executeUpdate();
            stm.close();
            conn.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateLivre(Livre l) {
        if(getLivreByref(l.getRef())==null) {
            return ;
        }
        String Query = "UPDATE Livres SET title = ?, prix = ?, qte = ? WHERE ref = ?";
        try(Connection conn = Db.getConn();
            PreparedStatement stm = conn.prepareStatement(Query)){
            stm.setString(1, l.getTitle());
            stm.setDouble(2, l.getPrix());
            stm.setInt(3, l.getQte());
            stm.setString(4, l.getRef());
            stm.executeUpdate();
            stm.close();
            conn.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Livre> getAllLivres(){
        List<Livre> Livres = new LinkedList<>();
        String Query = "SELECT * FROM Livres";
        try(Connection conn = Db.getConn();
            PreparedStatement stm = conn.prepareStatement(Query)){
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                Livres.add(new Livre(rs.getString("ref"),rs.getString("title"),rs.getDouble("prix"),rs.getInt("qte")));
            }
            stm.close();
            conn.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return Livres;
    }
}