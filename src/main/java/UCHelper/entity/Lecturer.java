/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Scanner;


public class Lecturer {
   private String name;
    private String userName;
    private String password;
    private String emailId;
    private String phoneNo;

    public Lecturer() {
    }

    public Lecturer(String name) {
        this.name = name;
    }
    
    
    public String name() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }

    public Lecturer(String name, String userName, String password, String emailId, String phoneNo) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
    }
    
   
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
   @Override
    public String toString() {
        return "Register [firstName=" + name + ", userName=" + userName + ", password=" +
            password + ", emailId=" + emailId + ", phoneNo=" + phoneNo + "]";
    }
}   