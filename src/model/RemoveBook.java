/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.DBConnection;

/**
 *
 * @author DCL
 */
public class RemoveBook extends Book{
    public RemoveBook(String bookName){
       this.bookName=bookName; 
    }
    public int removeBook(String bookName){
         DBConnection db = new DBConnection();     
         int count =0;
         count =db.removeBook(bookName);
         return count;
    }
}
