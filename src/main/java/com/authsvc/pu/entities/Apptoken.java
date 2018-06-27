package com.authsvc.pu.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @(#)Apptoken.java   17-Jan-2015 10:45:51
 *
 * Copyright 2011 NUROX Ltd, Inc. All rights reserved.
 * NUROX Ltd PROPRIETARY/CONFIDENTIAL. Use is subject to license 
 * terms found at http://www.looseboxes.com/legal/licenses/software.html
 */

/**
 * @author   chinomso bassey ikwuagwu
 * @version  2.0
 * @since    2.0
 */
@Entity
@Table(name = "apptoken")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apptoken.findAll", query = "SELECT a FROM Apptoken a"),
    @NamedQuery(name = "Apptoken.findByTokenid", query = "SELECT a FROM Apptoken a WHERE a.tokenid = :tokenid"),
    @NamedQuery(name = "Apptoken.findBySeriesid", query = "SELECT a FROM Apptoken a WHERE a.seriesid = :seriesid"),
    @NamedQuery(name = "Apptoken.findByToken", query = "SELECT a FROM Apptoken a WHERE a.token = :token"),
    @NamedQuery(name = "Apptoken.findByDatecreated", query = "SELECT a FROM Apptoken a WHERE a.datecreated = :datecreated"),
    @NamedQuery(name = "Apptoken.findByTimemodified", query = "SELECT a FROM Apptoken a WHERE a.timemodified = :timemodified")})
public class Apptoken implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tokenid")
    private Integer tokenid;
    @Basic(optional = false)
    @Column(name = "seriesid")
    private String seriesid;
    @Basic(optional = false)
    @Column(name = "token")
    private String token;
    @Basic(optional = false)
    @Column(name = "datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;
    @Basic(optional = false)
    @Column(name = "timemodified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timemodified;
    @JoinColumn(name = "appid", referencedColumnName = "appid")
    @OneToOne(optional = false)
    private App appid;

    public Apptoken() {
    }

    public Apptoken(Integer tokenid) {
        this.tokenid = tokenid;
    }

    public Apptoken(Integer tokenid, String seriesid, String token, Date datecreated, Date timemodified) {
        this.tokenid = tokenid;
        this.seriesid = seriesid;
        this.token = token;
        this.datecreated = datecreated;
        this.timemodified = timemodified;
    }

    public Integer getTokenid() {
        return tokenid;
    }

    public void setTokenid(Integer tokenid) {
        this.tokenid = tokenid;
    }

    public String getSeriesid() {
        return seriesid;
    }

    public void setSeriesid(String seriesid) {
        this.seriesid = seriesid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public Date getTimemodified() {
        return timemodified;
    }

    public void setTimemodified(Date timemodified) {
        this.timemodified = timemodified;
    }

    public App getAppid() {
        return appid;
    }

    public void setAppid(App appid) {
        this.appid = appid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tokenid != null ? tokenid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apptoken)) {
            return false;
        }
        Apptoken other = (Apptoken) object;
        if ((this.tokenid == null && other.tokenid != null) || (this.tokenid != null && !this.tokenid.equals(other.tokenid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.authsvc.pu.entities.Apptoken[ tokenid=" + tokenid + " ]";
    }

}
