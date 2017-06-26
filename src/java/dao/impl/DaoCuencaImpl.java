package dao.impl;

import dao.DaoCuenca;
import dto.Cuenca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import sql.ConectaDb;

public class DaoCuencaImpl implements DaoCuenca {

    private final ConectaDb db;
    private final StringBuilder sql;
    private List<String> messages;

    public DaoCuencaImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
        messages = new LinkedList<String>();
    }
    
    @Override
    public List<Cuenca> cuencaTemperaturaQRY() {
        List<Cuenca> list = null;
        sql.delete(0, sql.length())
        .append("SELECT * FROM cuenca_temperatura");
        
        try {
            Connection cn = db.getConnection();
            PreparedStatement ps
                = cn.prepareStatement(sql.toString());
            
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<Cuenca>();
            while(rs.next()){
                    Cuenca c = new Cuenca();
                    
                    c.setId_cuenca(rs.getInt(1));
                    c.setEne_value(rs.getFloat(2));
                    c.setFeb_value(rs.getFloat(3));
                    c.setMar_value(rs.getFloat(4));
                    c.setAbr_value(rs.getFloat(5));
                    c.setMay_value(rs.getFloat(6));
                    c.setJun_value(rs.getFloat(7));
                    c.setJul_value(rs.getFloat(8));
                    c.setAgo_value(rs.getFloat(9));
                    c.setSet_value(rs.getFloat(10));
                    c.setOct_value(rs.getFloat(11));
                    c.setNov_value(rs.getFloat(12));
                    c.setDic_value(rs.getFloat(13));
                    c.setAnual_value(rs.getFloat(14));
                    
                    System.out.println(rs.getInt(1));
                    list.add(c);
            }

        } catch (Exception e) {
            messages.add(e.getMessage());
        }
        
        return list;
    }

    @Override
    public List<Cuenca> cuencaPrecipitacionQRY() {
        List<Cuenca> list = null;
        sql.delete(0, sql.length())
        .append("SELECT * FROM cuenca_precipitacion");
        
        try {
            Connection cn = db.getConnection();
            PreparedStatement ps
                = cn.prepareStatement(sql.toString());
            
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<Cuenca>();
            while(rs.next()){
                    Cuenca c = new Cuenca();
                    
                    c.setId_cuenca(rs.getInt(1));
                    c.setEne_value(rs.getFloat(2));
                    c.setFeb_value(rs.getFloat(3));
                    c.setMar_value(rs.getFloat(4));
                    c.setAbr_value(rs.getFloat(5));
                    c.setMay_value(rs.getFloat(6));
                    c.setJun_value(rs.getFloat(7));
                    c.setJul_value(rs.getFloat(8));
                    c.setAgo_value(rs.getFloat(9));
                    c.setSet_value(rs.getFloat(10));
                    c.setOct_value(rs.getFloat(11));
                    c.setNov_value(rs.getFloat(12));
                    c.setDic_value(rs.getFloat(13));
                    c.setAnual_value(rs.getFloat(14));
                    
                    list.add(c);
            }
            
            rs.close();
            ps.close();
            cn.close();

        } catch (Exception e) {
            messages.add(e.getMessage());
        } 
        
        return list;
    }

    @Override
    public String getMessage() {
        String message = null;
        
        for (String m : messages) {
            message = message + m + "\n";
        }
        
        return message;
    }

    @Override
    public Cuenca cuencaAleatorio(int id, String nombreTabla) {
        Cuenca c = null;
        
        sql.delete(0, sql.length())
        .append("SELECT * FROM ")
        .append(nombreTabla)
        .append(" WHERE id_cuenca = ?");
        
        try {
            Connection cn = db.getConnection();
            PreparedStatement ps
                = cn.prepareStatement(sql.toString());
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                c = new Cuenca();
                
                c.setId_cuenca(rs.getInt(1));
                c.setEne_value(rs.getFloat(2));
                c.setFeb_value(rs.getFloat(3));
                c.setMar_value(rs.getFloat(4));
                c.setAbr_value(rs.getFloat(5));
                c.setMay_value(rs.getFloat(6));
                c.setJun_value(rs.getFloat(7));
                c.setJul_value(rs.getFloat(8));
                c.setAgo_value(rs.getFloat(9));
                c.setSet_value(rs.getFloat(10));
                c.setOct_value(rs.getFloat(11));
                c.setNov_value(rs.getFloat(12));
                c.setDic_value(rs.getFloat(13));
                c.setAnual_value(rs.getFloat(14));
            }
            
            rs.close();
            ps.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error en bd: "+e.getMessage());
        }
        
        return c;
    }

    @Override
    public List<Cuenca> getCuencas(String nombreTabla) {
        List<Cuenca> list = new LinkedList<>();
        
        for(int i = 0; i < 10; i++){
            int aleat = (int) (Math.random() * 468) + 1;
//            System.out.println("Aleatorio: "+aleat);
            Cuenca cuenca = cuencaAleatorio(aleat, nombreTabla);
            list.add(cuenca);
        }
        
        return list;
    }

    
}
