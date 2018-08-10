/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.DBConnection;
import javax.swing.JOptionPane;

/**
 *
 * @author DCL
 */
public class BorrowBook {
    private String bookName;
    DBConnection db = new DBConnection();
    public int borrowBook(String bookName,Borrower info){
        
       if( db.saveBorrower(bookName,info)>0 &&  db.editStatus(bookName)>0){
           return 1;
       }else{
           return 0;
       }
    }
    public int returnBook(String bookName){
        int update = db.returnUpdate( bookName);
        int remove = db.removeBorrower(bookName);
        if(update >0  &&   remove>0){
            return 1;
        }else{
            return 0;
        }
    }
    public void showError(){
        JOptionPane.showMessageDialog(null, "Return failed");
    }
}
