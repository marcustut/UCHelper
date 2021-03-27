/*
 * Name: Amirul Imran bin Ahmad Azam
 * Student ID: 19WMR12634
 * Course: RSF2G1
 * Date: May 2021
 */
package UCHelper.entity;

import java.util.Objects;


public class Lecturer {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String emailId;
    private String phoneNo;
    private String respClub;

    public Lecturer() {
    }

    public Lecturer(String firstName,String lastName, String userName, String password, String emailId, String phoneNo, String respClub) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
        this.respClub = respClub;
    }
    
    public String firstName() {
        return firstName;
    }
    public String getfirstName() {
        return firstName;
    }
    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }
   public String getlastName() {
        return lastName;
    }
    public void setlastName(String lastName) {
        this.lastName = lastName;
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
    public String getrespClub() {
        return respClub;
    }
    public void setrespClub(String respClub) {
        this.respClub = respClub;
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.firstName);
        hash = 17 * hash + Objects.hashCode(this.lastName);
        hash = 17 * hash + Objects.hashCode(this.userName);
        hash = 17 * hash + Objects.hashCode(this.password);
        hash = 17 * hash + Objects.hashCode(this.emailId);
        hash = 17 * hash + Objects.hashCode(this.phoneNo);
        hash = 17 * hash + Objects.hashCode(this.respClub);
        return hash;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lecturer other = (Lecturer) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.emailId, other.emailId)) {
            return false;
        }
        if (!Objects.equals(this.phoneNo, other.phoneNo)) {
            return false;
        }
        if (!Objects.equals(this.respClub, other.respClub)) {
            return false;
        }
        return true;
    }

   @Override
    public String toString() {
        return "Register [firstName=" + firstName + ", lastName=" + lastName +", userName=" + userName + ", password=" +
            password + ", emailId=" + emailId + ", phoneNo=" + phoneNo +", responsibleClub=" + respClub + "]";
    }
  
}   