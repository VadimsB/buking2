/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.buking2;

import javax.faces.bean.*;

/**
 *
 * @author user
 */
@ManagedBean(name = "webutils")
@SessionScoped
public class webutils {

    private String page = "userreg";

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public void pageUserreg() {
            this.page = "userreg";
        }
        public void pageTest2() {
            this.page = "test2";
        }
}
