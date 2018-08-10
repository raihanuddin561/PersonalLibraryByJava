/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.DBConnection;
import java.sql.Date;

/**
 *
 * @author DCL
 */
public class Borrower {
    private String name,contact,address;
    Date duration;

    public Borrower(String name, String contact, String address, Date duration) {
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    public Date getDuration() {
        return duration;
    }
    
    
    public void saveBorrower(String bookName,Borrower info){
        
    }
    public void showConfirmation(){
        
    }
    public void showBorrowerList(){
        
    }
    public void showError(){
        
    }
}
