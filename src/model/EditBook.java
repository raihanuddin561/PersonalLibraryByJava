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
public class EditBook extends Book {

    public EditBook() {
    }

    public EditBook(String authorName, String bookName) {
        this.authorName = authorName;
        this.bookName = bookName;
    }

    public int  editBook(String bookName,String authorName,String status) {
        DBConnection db = new DBConnection();     
        int count=db.editBook(bookName,authorName,status);
        return count;
    }
}
