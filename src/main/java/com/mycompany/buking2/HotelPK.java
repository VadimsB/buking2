/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.buking2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author user
 */
@Embeddable
public class HotelPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idHotel")
    private int idHotel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Country_idCountry")
    private int countryidCountry;

    public HotelPK() {
    }

    public HotelPK(int idHotel, int countryidCountry) {
        this.idHotel = idHotel;
        this.countryidCountry = countryidCountry;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public int getCountryidCountry() {
        return countryidCountry;
    }

    public void setCountryidCountry(int countryidCountry) {
        this.countryidCountry = countryidCountry;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idHotel;
        hash += (int) countryidCountry;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HotelPK)) {
            return false;
        }
        HotelPK other = (HotelPK) object;
        if (this.idHotel != other.idHotel) {
            return false;
        }
        if (this.countryidCountry != other.countryidCountry) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.buking2.HotelPK[ idHotel=" + idHotel + ", countryidCountry=" + countryidCountry + " ]";
    }
    
}
