/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rad.ussd.point;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="ussdRequests")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="COMMAND")
public class UssdRequest implements Serializable {

    @XmlElement(name="MSISDN")
    private String msisdn;
    @Id
    @XmlElement(name="SESSIONID")
    private String sessionId;
    @XmlElement(name="NEWREQUEST")
    private String new_request;
    @XmlElement(name="INPUT")
    private String input;
    @XmlElement(name="SPID")
private String spId;
    @XmlElement(name="AGENTID")
private int agentId;

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
    
    
    
}
