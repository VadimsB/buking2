/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Controller;

import com.mycompany.buking2.User;
import com.mycompany.facade.UserFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author user
 */
@ManagedBean(name="BukingController")
@SessionScoped

public class BukingController implements Serializable {
    private String Username;
    private String Password;
    private String CreditCardNr;
    private String Name;
    private String Surname;
    private String Address;
    @EJB
    private UserFacade ejbUserFacade;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getCreditCardNr() {
        return CreditCardNr;
    }

    public void setCreditCardNr(String CreditCardNr) {
        this.CreditCardNr = CreditCardNr;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public UserFacade getEjbUserFacade() {
        return ejbUserFacade;
    }

    public void setEjbUserFacade(UserFacade ejbUserFacade) {
        this.ejbUserFacade = ejbUserFacade;
    }
    
    public void createUser(){
        User user = new  User();
        user.setAddress(Address);
        user.setCreditCardNr(CreditCardNr);
        user.setName(Name);
        user.setPassword(Password);
        user.setSurname(Surname);
        user.setUsername(Username);
        try {
        getEjbUserFacade().create(user);
         System.out.println("viss ir ok");
         this.clearUserForm();
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Viss ir kartiba!","Viss saglabajas korekti :)"));
        } catch (Exception e) {
            System.out.println("kluda" + e);
        }
        }
    public void clearUserForm(){
        this.Address=null;
        this.CreditCardNr=null;
        this.Name=null;
        this.Surname=null;
        this.Username=null;
    }
}
