/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Controller;

import com.mycompany.buking2.Hotel;
import com.mycompany.facade.HotelFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="HotelController")
@SessionScoped
/**
 *
 * @author user
 */
public class HotelController {
    private String HotelName;
    private String HotelCity;
    private List<Hotel> hotelTable;
    @EJB
    private HotelFacade ejbHotelFacade;

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String HotelName) {
        this.HotelName = HotelName;
    }

    public String getHotelCity() {
        return HotelCity;
    }

    public void setHotelCity(String HotelCity) {
        this.HotelCity = HotelCity;
    }

    public List<Hotel> getHotelTable() {
        hotelTable=getEjbHotelFacade().findByParms(HotelCity, HotelName);
        return hotelTable;
    }

    public void setHotelTable(List<Hotel> hotelTable) {
        this.hotelTable = hotelTable;
    }

    public HotelFacade getEjbHotelFacade() {
        return ejbHotelFacade;
    }

    public void setEjbHotelFacade(HotelFacade ejbHotelFacade) {
        this.ejbHotelFacade = ejbHotelFacade;
    }
    
}
