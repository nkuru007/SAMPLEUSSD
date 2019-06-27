/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rad.ussd.point;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ismaelnzamutuma
 */
@XmlRootElement(name="COMMAND")
@XmlAccessorType(XmlAccessType.FIELD)
public class UssdResponsetoSP implements Serializable{
    
     @XmlElement(name = "MSISDN")
    private String msisdn;

    @XmlElement(name = "SESSIONID")
    private BigInteger sessionId;

    @XmlElement(name = "SPID")
    private String spid;

    @XmlElement(name = "INPUT")
    private String input;

    @XmlElement(name = "FREEFLOW")
    private String freeFlow;

    @XmlElement(name = "MESSAGE")
    private String messageTitle;

    @XmlElement(name = "NEWREQUEST")
    private int newRequest;

    @XmlElementWrapper(name = "MENUS")
    @XmlElement(name = "MENU")
    private List<String> menus;
    public String getMsisdn() {
        return msisdn;
    }

    /**
     * @param msisdn the msisdn to set
     */
    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    /**
     * @return the sessionId
     */
    public BigInteger getSessionId() {
        return sessionId;
    }

    /**
     * @param sessionId the sessionId to set
     */
    public void setSessionId(BigInteger sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * @return the spid
     */
    public String getSpid() {
        return spid;
    }

    /**
     * @param spid the spid to set
     */
    public void setSpid(String spid) {
        this.spid = spid;
    }

    /**
     * @return the input
     */
    public String getInput() {
        return input;
    }

    /**
     * @param input the input to set
     */
    public void setInput(String input) {
        this.input = input;
    }

    /**
     * @return the freeFlow
     */
    public String getFreeFlow() {
        return freeFlow;
    }

    /**
     * @param freeFlow the freeFlow to set
     */
    public void setFreeFlow(String freeFlow) {
        this.freeFlow = freeFlow;
    }

    /**
     * @return the messageTitle
     */
    public String getMessageTitle() {
        return messageTitle;
    }

    /**
     * @param messageTitle the messageTitle to set
     */
    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    /**
     * @return the newRequest
     */
    public int getNewRequest() {
        return newRequest;
    }

    /**
     * @param newRequest the newRequest to set
     */
    public void setNewRequest(int newRequest) {
        this.newRequest = newRequest;
    }

    /**
     * @return the menus
     */
    public List<String> getMenus() {
        return menus;
    }

    /**
     * @param menus the menus to set
     */
    public void setMenus(List<String> menus) {
        this.menus = menus;
    }

   
     
     
}
