/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbHelpers;

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.loai_san_pham;

/**
 *
 * @author Thy
 */
public class ReadRecord {
    
    private Connection conn;
    private ResultSet results;
    private loai_san_pham l = new loai_san_pham();
    int ma_loai;
    
    public ReadRecord(int ma_loai){
        Properties props  = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");//let me read content of a file 
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String password = props.getProperty("user.password");
        
        this.ma_loai = ma_loai;
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = (Connection) DriverManager.getConnection(url,username,password);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void doUpdate()
    {
        try {
            String Query = "select * from loai_san_pham where ma_loai = ?";
            
            PreparedStatement ps = conn.prepareStatement(Query);
            
            ps.setInt(1, ma_loai);
            this.results = ps.executeQuery();
            
            this.results.next();
            
            l.setMa_loai(this.results.getInt("ma_loai"));
            l.setTen_loai(this.results.getString("ten_loai"));
            l.setMo_ta(this.results.getString("mo_ta"));
            l.setMa_loai_cha(this.results.getInt("ma_loai_cha"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
     public loai_san_pham getLoai_san_pham()
    {
        
        return this.l;
    }
    
}
