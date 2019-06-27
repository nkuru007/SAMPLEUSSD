/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rad.ussd.services;

import com.rad.ussd.point.CommonLibrary;
import com.rad.ussd.point.RadiantSessionManager;
import com.rad.ussd.point.RadiantUssdNavigation;
import com.rad.ussd.point.UssdRequest;
import com.rad.ussd.point.UssdResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ussd.radiant.messageResources.BundleResourceManager;

/**
 *
 * @author inzamutuma
 */
@Path("ussd")
@Stateless
public class GeneralRadiantUssdNavigation {

    @EJB
    private RadiantSessionManager radiantSessionManager;
    @EJB
    private BundleResourceManager messages;
    private String nextValue;

    @Path("mainmenu")
    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public String mainMenu(UssdRequest urb) {
        final String urlservices = "http://localhost:8080/radiantservices/";

        RadiantUssdNavigation un = new RadiantUssdNavigation();
        UssdResponse urs = new UssdResponse();

        String nextValue = "Language";
        int nextkey = 0;
        List<String> emptyList = new ArrayList<>();
        emptyList.add(" ");
        List<String> menus = new ArrayList<>();

        un = (RadiantUssdNavigation) this.getRadiantSessionManager().checkMsisdnSession(urb.getMsisdn());
        long diff = 0;
        if (un != null) {
            diff = (new java.util.Date().getTime() - un.getLastAccessed().getTime()) / 1000;
        }
        // the 60 seconds is the session life before it is expired.
        if (diff > 20) // of more than one minutes without trying, the session is closed 
        {
            getRadiantSessionManager().terminateMisdnSession(urb.getMsisdn(), un);
        }

        if (urb.getNew_request().equals("1") && urb.getInput().equals("712*100")) {
            nextValue = "Language";
            nextkey = 1;
            un = new RadiantUssdNavigation();

            un.getMsdnthreads().put(nextkey, "Language");
            this.getRadiantSessionManager().addmisdnSession(urb.getMsisdn(), un);
        }

        nextkey = Collections.max(un.getMsdnthreads().keySet());
        nextValue = un.getMsdnthreads().get(Collections.max(un.getMsdnthreads().keySet()));
        System.out.println("Next Key: " + nextkey);
        System.out.println("Next Value: " + nextValue);
        switch (nextValue) {
            case "Language":
                un.setLastAccessed(new java.util.Date());

                List<String> list2 = new ArrayList();

                list2.add("1. Kinyarwanda^");
                list2.add("2. English^");
                list2.add("3. Français^");
                urs.setMenus(list2);
                urs.setAgentId(urb.getAgentId());
                urs.setFreeFlow("FC");
                urs.setMenuTitle("^^ ");
                urs.setMsisdn(urb.getMsisdn());
                urs.setNew_request("0");
                urs.setSessionId(urb.getSessionId());
                urs.setSpId(urb.getSpId());
                un.getPreviousMenus().put(nextkey, list2);
                un.getPreviousTitle().put(nextkey, "");
                un.getMsdnthreads().put(nextkey + 1, "welcome");

                un.setLastAccessed(new java.util.Date());
                this.getRadiantSessionManager().addmisdnSession(urb.getMsisdn(), un);
                break;

            case "welcome":
                Map<String, String> languages = new HashMap<>();
                languages.put("1", "ki");
                languages.put("2", "en");
                languages.put("3", "fr");
                String urlclientnames = urlservices + "insuranceservices/clientphone/" + urb.getMsisdn().substring(urb.getMsisdn().length() - 10);
                Response responsenames = CommonLibrary.sendRESTRequest(urlclientnames, "", MediaType.TEXT_PLAIN, "GET");
                String names = " ";
                if (responsenames.getStatus() == 200) {
                    names = responsenames.readEntity(String.class);
                }
                un.setLanguage(languages.get(urb.getInput()));
                ///System.out.println(this.getMessages().getMessage("welcome", un.getLanguage()));
                // String message =this.getMessages().getMessage("welcome", un.getLanguage());
                urs.setAgentId(urb.getAgentId());
                urs.setFreeFlow("FC");
                //urs.setMenuTitle(this.getMessages().getMessage("welcome", un.getLanguage()));
                urs.setMenuTitle("Welcome " + names.toUpperCase().trim() + " to Radiant Insurance Company^ A Promise is a Promise^-------------------------^ ");
                List<String> list3 = new ArrayList<>();
                // list3.add(this.getMessages().getMessage("next", un.getLanguage()));
                //  list3.add(this.getMessages().getMessage("back", un.getLanguage()));
                list3.add("1. Continue^");
                list3.add("2. Back^");
                urs.setMenus(list3);
                urs.setMsisdn(urb.getMsisdn());
                urs.setNew_request("0");
                un.getPreviousMenus().put(nextkey, list3);
                un.getMsdnthreads().put(nextkey + 1, "insuranceproducts");
                un.getPreviousMenus().put(nextkey, (List) un.getPreviousMenus().get(nextkey - 1));
                un.getPreviousTitle().put(nextkey - 1, "");
                un.setLastAccessed(new java.util.Date());
                this.getRadiantSessionManager().addmisdnSession(urb.getMsisdn(), un);

                break;
            case "insuranceproducts":
                // System.out.println(urb.getInput());
                switch (urb.getInput()) {
                    case "1":
                        un.setAgentid(urb.getAgentId());
                        un.setLastAccessed(new java.util.Date());
                        un.setSessionid(urb.getSessionId());
                        un.setMsisdn(urb.getMsisdn());

                        un.getMsdnthreads().put(nextkey + 1, "productmanagement");
                        List<String> products = new ArrayList<>();
                        products.add("1. Checking Insurance ^");
                        products.add("2. My Insurances ^");
                        products.add("3. New Subscription^");
                        products.add("4. Livestocks^");
                        products.add("5.Ingoboka Cash^");
                        products.add("6. Back^");

                        urs.setMenus(products);
                        urs.setMenuTitle("Radiant Insurance Company for All^--------------------------------^");
                        urs.setAgentId(urb.getAgentId());
                        urs.setFreeFlow("FC");
                        urs.setMsisdn(urb.getMsisdn());
                        urs.setNew_request("0");
                        urs.setSpId(urb.getSpId());
                        urs.setSessionId(urb.getSessionId());
                        un.getPreviousMenus().put(nextkey, (List) un.getPreviousMenus().get(nextkey));
                        un.getPreviousTitle().put(nextkey, (String) un.getPreviousTitle().get(nextkey));

                        this.getRadiantSessionManager().addmisdnSession(urb.getMsisdn(), un);
                        break;
                    case "2":
                        un.setAgentid(urb.getAgentId());
                        un.setSessionid(urb.getSessionId());
                        un.setMsisdn(urb.getMsisdn());
                        un.getMsdnthreads().remove(Collections.max(un.getMsdnthreads().keySet()));
                        int maximumkey = Collections.max(un.getMsdnthreads().keySet());
                        String maximumvalue = un.getPreviousTitle().get(Collections.max(un.getMsdnthreads().keySet()));
                        System.out.println("Maximum key: " + maximumkey);
                        System.out.println("Maximum key: " + maximumvalue);
                        un.getMsdnthreads().put(nextkey, un.getMsdnthreads().get(nextkey));
                        un.getMsdnthreads().put(nextkey, un.getPreviousTitle().get(nextkey));

                        un.setLastAccessed(new java.util.Date());
                        urs.setMenuTitle(un.getPreviousTitle().get(nextkey - 1));
                        urs.setMenus((List) un.getPreviousMenus().get(nextkey - 1));
                        urs.setAgentId(urb.getAgentId());
                        urs.setFreeFlow("FC");
                        urs.setMsisdn(urb.getMsisdn());
                        urs.setNew_request("0");
                        urs.setSessionId(urb.getSessionId());
                        urs.setSpId(urb.getSpId());
                        this.getRadiantSessionManager().addmisdnSession(urb.getMsisdn(), un);

                        break;
                    default:

                        break;
                }
                break;   /// products case 

            case "productmanagement":

                break;

        } //end of switch nextValue
        return CommonLibrary.marchalling(urs, UssdResponse.class);

    }   // doprocessrequest method

    /**
     * @return the radiantSessionManager
     */
    public RadiantSessionManager getRadiantSessionManager() {
        return radiantSessionManager;
    }

    /**
     * @param radiantSessionManager the radiantSessionManager to set
     */
    public void setRadiantSessionManager(RadiantSessionManager radiantSessionManager) {
        this.radiantSessionManager = radiantSessionManager;
    }

    /**
     * @return the messages
     */
    public BundleResourceManager getMessages() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMessages(BundleResourceManager messages) {
        this.messages = messages;
    }

    /**
     * @return the nextValue
     */
    public String getNextValue() {
        return nextValue;
    }

    /**
     * @param nextValue the nextValue to set
     */
    public void setNextValue(String nextValue) {
        this.nextValue = nextValue;
    }

}
