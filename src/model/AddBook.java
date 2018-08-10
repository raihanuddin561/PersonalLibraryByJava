package model;

import dao.DBConnection;


public class AddBook extends Book {

    public AddBook() {
    }

    public AddBook(String bookName, String authorName,String status) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.status = status;
    }

    public void addBook(AddBook info) {
        DBConnection db = new DBConnection();
        db.addBook( info);
    }
}
