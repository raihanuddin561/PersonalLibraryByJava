
package model;

public class Book {
    protected String bookName, authorName,status;

    public Book(String bookName, String authorName, String status) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.status = status;
    }

    public Book() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    
    
    public void showBook(String bookName){
        
    }

    public String getStatus() {
        return status;
    }
    public void showConfirmation(){
        
    }
    public void showError(){
        
    }
}
