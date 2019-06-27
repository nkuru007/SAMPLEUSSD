/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rad.ussd.point;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import javax.ejb.Singleton;


/**
 *
 * @author ismaelnzamutuma
 */

@Singleton
public class RadiantSessionManager implements Serializable {
     private ConcurrentHashMap<String, RadiantUssdNavigation> missdnSessions = new ConcurrentHashMap<>();
    
     public RadiantUssdNavigation checkMsisdnSession(String msisdn)
     {
       
         
         return (RadiantUssdNavigation)missdnSessions.get(msisdn);
         
         
     }
     
   public void addmisdnSession(String msisdn,RadiantUssdNavigation un)
   {
       missdnSessions.put(msisdn, un);
   }
 public void terminateMisdnSession(String msisdn,RadiantUssdNavigation un)
   {
       missdnSessions.remove(msisdn);
   }

 
   
}
