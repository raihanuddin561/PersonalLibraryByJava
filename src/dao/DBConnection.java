package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import model.AddBook;
import model.Book;
import model.Borrower;
import model.EditBook;
import net.proteanit.sql.DbUtils;

public class DBConnection {

    public static Connection getConnection() {
        Connection conn = null;
        String URL = "jdbc:mysql://localhost:3306/personallibrary?useSSL=false";
        String User = "root";
        String Password = "raihan";

        try {
            if (conn == null) {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(URL, User, Password);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }

        return conn;

    }

    public void addBook(AddBook info) {
        Connection con = null;
        PreparedStatement st = null;
        String sql = "INSERT INTO book(bookName,authorName,status) VALUES(?,?,?);";
        try {
            con = getConnection();
            st = con.prepareStatement(sql);
            st.setString(1, info.getBookName());
            st.setString(2, info.getAuthorName());
            st.setString(3, info.getStatus());
            int rs = st.executeUpdate();
            if (rs != 0) {
                System.out.println("Successfully added");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int editBook(String bookName,String authorName ,String status) {
        Connection con = null;
        PreparedStatement st = null;
        int count=0;
        String sql = "UPDATE book SET authorName=?, status=?  WHERE bookName=?";
        try {
            con = getConnection();
            st = con.prepareStatement(sql);
            st.setString(1, authorName);
            st.setString(2,status);
            st.setString(3,bookName);
            count= st.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
 public int removeBook(String bookName) {
        Connection con = null;
        PreparedStatement st = null;
        int count =0;
        String sql = "delete from book WHERE bookName=?";
        try {
            con = getConnection();
            st = con.prepareStatement(sql);
            st.setString(1, bookName);
             count = st.executeUpdate();
            if (count > 0) {
               return count;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public void searchBook(String bookName,JTable table) {
        Connection con = null;
        PreparedStatement st = null;
        String sql = "select * from book WHERE bookName=?";
        try {
            con = getConnection();
            st = con.prepareStatement(sql);
            st.setString(1, bookName);
            ResultSet rs = st.executeQuery();
           table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void fetchBookList(JTable table){
          Connection con = null;
       Statement st = null;
        String sql = "select * from book ";
        try {
            con = getConnection();
            st = con.createStatement();
          
            ResultSet rs = st.executeQuery(sql);
           table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fetchBookToRemove(JTable table,String bookName) {
         Connection con = null;
       PreparedStatement pst = null;
        String sql = "select * from book where bookName=? ";
        try {
            con = getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, bookName);
          
            ResultSet rs = pst.executeQuery();
           table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fetchAvailableBookList(JTable table) {
        Connection con = null;
       PreparedStatement pst = null;
        String sql = "select * from book where status=? ";
        try {
            con = getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, "available");
          
            ResultSet rs = pst.executeQuery();
           table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }

    public int saveBorrower(String bookName, Borrower info) {
         //To change body of generated methods, choose Tools | Templates.
          Connection con = null;
        PreparedStatement st = null;
        String sql = "INSERT INTO borrower(bookname,borrowername,address,contact,duedate) VALUES(?,?,?,?,?)";
        int count=0;
        try {
            con = getConnection();
            st = con.prepareStatement(sql);
            st.setString(1, bookName);
            st.setString(2, info.getName());
            st.setString(3,info.getAddress());
            st.setString(4, info.getContact());
            st.setDate(5,info.getDuration() );
            count = st.executeUpdate();
            if (count != 0) {
                System.out.println("Successfully added");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
   }

    public int editStatus(String bookName) {
        //To change body of generated methods, choose Tools | Templates.
         Connection con = null;
        PreparedStatement st = null;
        int count=0;
        String sql = "UPDATE book SET  status=?  WHERE bookname=?";
        try {
            con = getConnection();
            st = con.prepareStatement(sql);
            st.setString(1, "borrowed");
            st.setString(2,bookName);
            count= st.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
       
    }
    public int returnUpdate(String bookName){
           Connection con = null;
        PreparedStatement st = null;
        int count=0;
        String sql = "UPDATE book SET  status=?  WHERE bookname=?";
        try {
            con = getConnection();
            st = con.prepareStatement(sql);
            st.setString(1, "available");
            st.setString(2,bookName);
            count= st.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    public int removeBorrower(String bookName){
        Connection con = null;
        PreparedStatement st = null;
        int count =0;
        String sql = "delete from borrower WHERE bookName=?";
        try {
            con = getConnection();
            st = con.prepareStatement(sql);
            st.setString(1, bookName);
             count = st.executeUpdate();
            if (count > 0) {
              System.out.println("Deleted from borrow list");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
        
        
    }

    public void fetchBorrowerList(JTable table) {
         Connection con = null;
       Statement pst = null;
        String sql = "select * from borrower ";
        try {
            con = getConnection();
            pst = con.createStatement();
            
          
            ResultSet rs = pst.executeQuery(sql);
           table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
