/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.DBConnection;
import javax.swing.JTable;

/**
 *
 * @author DCL
 */
public class SearchBook extends Book{
    
    

    public SearchBook(String bookName) {
        this.bookName=bookName;
    }
    public void searchBook(String bookName,JTable table){
     DBConnection db = new DBConnection();     
        db.searchBook(bookName,table);   
    }
    public void showError(){
        
    }
}
