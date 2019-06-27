/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rad.ussd.point;

import java.io.Serializable;
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
public class UssdResponse implements Serializable {
      @XmlElement(name="MSISDN")
    private String msisdn;
   
    @XmlElement(name="SESSIONID")
    private String sessionId;
    @XmlElement(name="NEWREQUEST")
    private String new_request;
    @XmlElement(name="SPID",nillable=true)
    private String spId;
     @XmlElement(name="AGENTID",nillable=true)
private int agentId;
     
     @XmlElement(name="MESSAGE")
     private String menuTitle;
     
     
     @XmlElementWrapper(name="MENUS")
    @XmlElements({
    @XmlElement(name="MENU") }
    )
    
     private List<String> menus;
     @XmlElement(name="FREEFLOW")
 private String freeFlow;

    /**
     * @return the msisdn
     */
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
    public String getSessionId() {
        return sessionId;
    }

    /**
     * @param sessionId the sessionId to set
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * @return the new_request
     */
    public String getNew_request() {
        return new_request;
    }

    /**
     * @param new_request the new_request to set
     */
    public void setNew_request(String new_request) {
        this.new_request = new_request;
    }

    /**
     * @return the spId
     */
    public String getSpId() {
        return spId;
    }

    /**
     * @param spId the spId to set
     */
    public void setSpId(String spId) {
        this.spId = spId;
    }

    /**
     * @return the agentId
     */
    public int getAgentId() {
        return agentId;
    }

    /**
     * @param agentId the agentId to set
     */
    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    /**
     * @return the menuTitle
     */
    public String getMenuTitle() {
        return menuTitle;
    }

    /**
     * @param menuTitle the menuTitle to set
     */
    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
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
     
     
     
     
}
