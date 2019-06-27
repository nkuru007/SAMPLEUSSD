/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rad.ussd.point;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="USSDNAVIGATION")
@XmlAccessorType(XmlAccessType.FIELD)
public class RadiantUssdNavigation implements Serializable{
    @XmlElement(name="SESSIONID")
    private String sessionid;
   
    @XmlElement(name="AGENTID")
    private int agentid;
    @XmlElement(name="MSISDN")
    private String msisdn;
    @XmlElement(name="NEXTVALUE")
    private String nextValue;
    @XmlElement(name="PREVIOUSVALUE")
    private String previousValue;
    @XmlTransient
    private java.util.Date lastAccessed;
    @XmlTransient
    private String language;
    @XmlTransient
    private String operationUrl;
    @XmlTransient
    private Map<Integer,String> msdnthreads=new HashMap<>();
    @XmlTransient
    private Map<Integer,Object> datamap = new HashMap<>();
    private Map<Integer,List<String>> previousMenus = new HashMap<>();
    private Map<Integer,String> previousTitle = new HashMap<>();
    
   // private TicketParametersBean ticket=new TicketParametersBean();

    /**
     * @return the sessionid
     */
    public String getSessionid() {
        return sessionid;
    }

    /**
     * @param sessionid the sessionid to set
     */
    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    /**
     * @return the agentid
     */
    public int getAgentid() {
        return agentid;
    }

    /**
     * @param agentid the agentid to set
     */
    public void setAgentid(int agentid) {
        this.agentid = agentid;
    }

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
     * @return the previousValue
     */
    public String getPreviousValue() {
        return previousValue;
    }

    /**
     * @param previousValue the previousValue to set
     */
    public void setPreviousValue(String previousValue) {
        this.previousValue = previousValue;
    }

    /**
     * @return the lastAccessed
     */
    public java.util.Date getLastAccessed() {
        return lastAccessed;
    }

    /**
     * @param lastAccessed the lastAccessed to set
     */
    public void setLastAccessed(java.util.Date lastAccessed) {
        this.lastAccessed = lastAccessed;
    }

    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return the operationUrl
     */
    public String getOperationUrl() {
        return operationUrl;
    }

    /**
     * @param operationUrl the operationUrl to set
     */
    public void setOperationUrl(String operationUrl) {
        this.operationUrl = operationUrl;
    }

    /**
     * @return the msdnthreads
     */
    public Map<Integer,String> getMsdnthreads() {
        return msdnthreads;
    }

    /**
     * @param msdnthreads the msdnthreads to set
     */
    public void setMsdnthreads(Map<Integer,String> msdnthreads) {
        this.msdnthreads = msdnthreads;
    }

    /**
     * @return the datamap
     */
    public Map<Integer,Object> getDatamap() {
        return datamap;
    }

    /**
     * @param datamap the datamap to set
     */
    public void setDatamap(Map<Integer,Object> datamap) {
        this.datamap = datamap;
    }

    /**
     * @return the previousMenus
     */
    public Map<Integer,List<String>> getPreviousMenus() {
        return previousMenus;
    }

    /**
     * @param previousMenus the previousMenus to set
     */
    public void setPreviousMenus(Map<Integer,List<String>> previousMenus) {
        this.previousMenus = previousMenus;
    }

    /**
     * @return the previousTitle
     */
    public Map<Integer,String> getPreviousTitle() {
        return previousTitle;
    }

    /**
     * @param previousTitle the previousTitle to set
     */
    public void setPreviousTitle(Map<Integer,String> previousTitle) {
        this.previousTitle = previousTitle;
    }
    
   
    
   
}
