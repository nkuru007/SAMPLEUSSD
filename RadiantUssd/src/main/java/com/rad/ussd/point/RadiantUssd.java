/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rad.ussd.point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ussd.radiant.messageResources.BundleResourceManager;

/**
 *
 * @author inzamutuma
 */
@WebServlet(name = "RadiantUssdServlet", urlPatterns = {"/radiant/ussd/entrypoint"})
public class RadiantUssd extends  HttpServlet{
     @EJB
private RadiantSessionManager radiantSessionManager;
     @EJB
     private BundleResourceManager messages;
    private String nextValue;
    @EJB
    private BundleResourceManager messagesmanager;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    
        StringBuilder sb = new StringBuilder();
       // try {
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String line = null;

            while ((line = in.readLine()) != null) {

                sb.append(line);

            }
             UssdRequest urb = (UssdRequest) CommonLibrary.unmarshalling(sb.toString(), UssdRequest.class);
          
        RadiantUssdNavigation un = new RadiantUssdNavigation();
            UssdResponse urs = new UssdResponse();
            
    String nextValue="Language";
       int nextkey=0;
         List<String> emptyList = new ArrayList<>();
         emptyList.add(" ");
           List<String> menus = new ArrayList<>();
    
            PrintWriter out = response.getWriter();
            un = (RadiantUssdNavigation)  this.getRadiantSessionManager().checkMsisdnSession(urb.getMsisdn());
            long diff = 0;
            if (un != null) {
                diff = (new java.util.Date().getTime() - un.getLastAccessed().getTime()) / 1000;
            }
            // the 60 seconds is the session life before it is expired.
            if (diff > 20) // of more than one minutes without trying, the session is closed 
            {
                getRadiantSessionManager().terminateMisdnSession(urb.getMsisdn(), un);
            }
            
           if(urb.getNew_request().equals("1") && urb.getInput().equals("181"))
           {
             nextValue="Language";
            nextkey=1;
           un= new RadiantUssdNavigation();
           
           un.getMsdnthreads().put(nextkey, "Language");
           this.getRadiantSessionManager().addmisdnSession(urb.getMsisdn(), un);
                 }
       
         nextkey=Collections.max(un.getMsdnthreads().keySet());
        nextValue=un.getMsdnthreads().get(Collections.max(un.getMsdnthreads().keySet()));
         switch(nextValue)
   {
         case "Language":
           un.setLastAccessed(new java.util.Date());
                                
                                List<String> list2 = new ArrayList();
                                
                                list2.add("1. Kinyarwanda^");
                                list2.add("2. English^");
                                list2.add("3. Francais^");
                                urs.setMenus(list2);
                                urs.setAgentId(urb.getAgentId());
                                urs.setFreeFlow("FC");
                                urs.setMenuTitle("^^ ");
                                urs.setMsisdn(urb.getMsisdn());
                                urs.setNew_request("0");
                                urs.setSessionId(urb.getSessionId());
                                urs.setSpId(urb.getSpId());
                                 un.getMsdnthreads().put(nextkey+1, "welcome");
                                 un.setLastAccessed(new java.util.Date());
                              this.getRadiantSessionManager().addmisdnSession(urb.getMsisdn(), un);
                             break;
     
         case "welcome":
               Map<String,String> languages = new HashMap<>();
           languages.put("1", "ki");
           languages.put("2", "en");
           languages.put("3", "fr");
        un.setLanguage(languages.get(urb.getInput()));
        String message =this.getMessages().getMessage("welcome", un.getLanguage());
        urs.setAgentId(urb.getAgentId());
        urs.setFreeFlow("FC");
        urs.setMenuTitle(message);
        List<String> list3 = new ArrayList<>();
        list3.add(this.getMessages().getMessage("next", un.getLanguage()));
        list3.add(this.getMessages().getMessage("back", un.getLanguage()));
        urs.setMenus(list3);
        urs.setMsisdn(urb.getMsisdn());
        urs.setNew_request("0");
        un.getMsdnthreads().put(nextkey+1, "insuranceproducts");
        un.setLastAccessed(new java.util.Date());
        this.getRadiantSessionManager().addmisdnSession(urb.getMsisdn(), un);
        
             break;
            
     
             
         } //end of switch nextValue
out.println(CommonLibrary.marchalling(urs, UssdResponse.class));
    }   // doprocessrequest method
     
   
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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

    /**
     * @return the messagesmanager
     */
    public BundleResourceManager getMessagesmanager() {
        return messagesmanager;
    }

    /**
     * @param messagesmanager the messagesmanager to set
     */
    public void setMessagesmanager(BundleResourceManager messagesmanager) {
        this.messagesmanager = messagesmanager;
    }

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
  
     
}
