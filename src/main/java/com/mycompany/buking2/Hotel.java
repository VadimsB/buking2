/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.buking2;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "hotel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hotel.findAll", query = "SELECT h FROM Hotel h"),
    @NamedQuery(name = "Hotel.findByIdHotel", query = "SELECT h FROM Hotel h WHERE h.hotelPK.idHotel = :idHotel"),
    @NamedQuery(name = "Hotel.findByHotelName", query = "SELECT h FROM Hotel h WHERE h.hotelName = :hotelName"),
    @NamedQuery(name = "Hotel.findByHotelCity", query = "SELECT h FROM Hotel h WHERE h.hotelCity = :hotelCity"),
    @NamedQuery(name = "Hotel.findByHotelAddr", query = "SELECT h FROM Hotel h WHERE h.hotelAddr = :hotelAddr"),
    @NamedQuery(name = "Hotel.findByStars", query = "SELECT h FROM Hotel h WHERE h.stars = :stars"),
    @NamedQuery(name = "Hotel.findByCountryidCountry", query = "SELECT h FROM Hotel h WHERE h.hotelPK.countryidCountry = :countryidCountry")})
public class Hotel implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HotelPK hotelPK;
    @Size(max = 45)
    @Column(name = "HotelName")
    private String hotelName;
    @Size(max = 45)
    @Column(name = "HotelCity")
    private String hotelCity;
    @Size(max = 45)
    @Column(name = "HotelAddr")
    private String hotelAddr;
    @Column(name = "Stars")
    private Integer stars;
    @JoinColumn(name = "Country_idCountry", referencedColumnName = "idCountry", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Country country;

    public Hotel() {
    }

    public Hotel(HotelPK hotelPK) {
        this.hotelPK = hotelPK;
    }

    public Hotel(int idHotel, int countryidCountry) {
        this.hotelPK = new HotelPK(idHotel, countryidCountry);
    }

    public HotelPK getHotelPK() {
        return hotelPK;
    }

    public void setHotelPK(HotelPK hotelPK) {
        this.hotelPK = hotelPK;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelCity() {
        return hotelCity;
    }

    public void setHotelCity(String hotelCity) {
        this.hotelCity = hotelCity;
    }

    public String getHotelAddr() {
        return hotelAddr;
    }

    public void setHotelAddr(String hotelAddr) {
        this.hotelAddr = hotelAddr;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hotelPK != null ? hotelPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hotel)) {
            return false;
        }
        Hotel other = (Hotel) object;
        if ((this.hotelPK == null && other.hotelPK != null) || (this.hotelPK != null && !this.hotelPK.equals(other.hotelPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.buking2.Hotel[ hotelPK=" + hotelPK + " ]";
    }
    
}
