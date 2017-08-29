
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


public class ReadQuery {
    private Connection conn;
    private ResultSet results;
    private loai_san_pham l = new loai_san_pham();
    
    public ReadQuery(){
        Properties props  = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");//let me read content of a file 
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String password = props.getProperty("user.password");
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = (Connection) DriverManager.getConnection(url,username,password);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doRead(){
        try {
            String query = "select * from loai_san_pham";
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void doAdd(loai_san_pham sp)
    {
        try {
            String query = "insert into loai_san_pham(ten_loai,mo_ta,ma_loai_cha) values(?,?,?)";
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(query);
            
            ps.setString(1,sp.getTen_loai());
            ps.setString(2,sp.getMo_ta());
            ps.setInt(3, sp.getMa_loai_cha());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
     public void doDelete(int ma_loai)
    {
        try {
            String Query = "delete from loai_san_pham where ma_loai=?";
            
            PreparedStatement ps = conn.prepareStatement(Query);
            
            ps.setInt(1, ma_loai);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeleteQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public void doUpdate(loai_san_pham l)
    {
        try {
            String Query = "update loai_san_pham set ten_loai = ?, mo_ta = ?, ma_loai_cha=? where ma_loai=?";
            
            PreparedStatement ps = conn.prepareStatement(Query);
            
            ps.setString(1, l.getTen_loai());
            ps.setString(2, l.getMo_ta());
            ps.setInt(3, l.getMa_loai_cha());
            ps.setInt(4, l.getMa_loai());
            
            ps.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
     
    public String getHTMLtable(){
        String table="";
        table += "<table border=1>";
        
        
        try {
            while(this.results.next())
            {
                
                l.setMa_loai(this.results.getInt("ma_loai"));
                l.setTen_loai(this.results.getString("ten_loai"));
                l.setMo_ta(this.results.getString("mo_ta"));
                l.setMa_loai_cha(this.results.getInt("ma_loai_cha"));
                
                table += "<tr>";
                
                    table += "<td>";
                    table += l.getMa_loai();
                    table += "</td>";

                    table += "<td>";
                    table += l.getTen_loai();
                    table += "</td>";

                    table += "<td>";
                    table += l.getMo_ta();
                    table += "</td>";

                    table += "<td>";
                    table += l.getMa_loai_cha();
                    table += "</td>";
                    
                    table += "<td>";
                    table += "<a href=update?ma_loai=" + l.getMa_loai() +"> Update </a>" + "<a href=delete?ma_loai="+ l.getMa_loai() + "> Delete </a>";
                    table += "</td>";
                
                
                table += "</tr>";
            }
        table += "</table>";
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return table;
    }
    
    public void doSearch(String ten_loai)
    {
        try {
            String Query ="select * from loai_san_pham where ten_loai like ?";
            
            PreparedStatement ps = conn.prepareStatement(Query);
            ps.setString(1, "%"+ten_loai+"%");
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String getSearchtable(){
        String table="";
        table += "<table border=1>";
        
        
        try {
            while(this.results.next())
            {
                
                l.setMa_loai(this.results.getInt("ma_loai"));
                l.setTen_loai(this.results.getString("ten_loai"));
                l.setMo_ta(this.results.getString("mo_ta"));
                l.setMa_loai_cha(this.results.getInt("ma_loai_cha"));
                
                table += "<tr>";
                
                    table += "<td>";
                    table += l.getMa_loai();
                    table += "</td>";

                    table += "<td>";
                    table += l.getTen_loai();
                    table += "</td>";

                    table += "<td>";
                    table += l.getMo_ta();
                    table += "</td>";

                    table += "<td>";
                    table += l.getMa_loai_cha();
                    table += "</td>";
                    
                    table += "<td>";
                    table += "<a href=update?ma_loai=" + l.getMa_loai() +"> Update </a>" + "<a href=delete?ma_loai="+ l.getMa_loai() + "> Delete </a>";
                    table += "</td>";
                
                
                table += "</tr>";
            }
        table += "</table>";
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return table;
    }
    
    public loai_san_pham getLoai_san_pham()
    {
        
        return this.l;
    }
   
    
}
