/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facade;

import com.mycompany.buking2.Hotel;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author user
 */
@Stateless
public class HotelFacade extends AbstractFacade<Hotel> {
    @PersistenceContext(unitName = "com.mycompany_buking2_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HotelFacade() {
        super(Hotel.class);
    }
    
    public List<Hotel> findByParms(String hotelCity, String hotelName ) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Hotel> q = cb.createQuery(Hotel.class);
        Root<Hotel> Hotel = q.from(Hotel.class);
        List<Predicate> predicateList = new ArrayList<Predicate>();
        
        Predicate hotelCityPredicate, hotelNamePredicate;

        if ((hotelCity != null) && (!(hotelCity.isEmpty()))) {
            hotelCityPredicate = cb.like(Hotel.<String>get("hotelCity"), hotelCity);
            predicateList.add(hotelCityPredicate);
        }

        if ((hotelName != null) && (!(hotelName.isEmpty()))) {
            hotelNamePredicate = cb.like(Hotel.<String>get("hotelName"), hotelName);
            predicateList.add(hotelNamePredicate);
        }
        
        Predicate[] predicates = new Predicate[predicateList.size()];
        predicateList.toArray(predicates);
        q.where(predicates);
        TypedQuery<Hotel> query = em.createQuery(q);
        return query.setMaxResults(10).getResultList();
    }



}
