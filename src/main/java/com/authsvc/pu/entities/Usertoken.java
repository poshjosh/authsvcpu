package com.authsvc.pu.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @(#)Usertoken.java   17-Jan-2015 10:45:51
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
@Table(name = "usertoken")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usertoken.findAll", query = "SELECT u FROM Usertoken u"),
    @NamedQuery(name = "Usertoken.findByTokenid", query = "SELECT u FROM Usertoken u WHERE u.tokenid = :tokenid"),
    @NamedQuery(name = "Usertoken.findBySeriesid", query = "SELECT u FROM Usertoken u WHERE u.seriesid = :seriesid"),
    @NamedQuery(name = "Usertoken.findByToken", query = "SELECT u FROM Usertoken u WHERE u.token = :token"),
    @NamedQuery(name = "Usertoken.findByDatecreated", query = "SELECT u FROM Usertoken u WHERE u.datecreated = :datecreated"),
    @NamedQuery(name = "Usertoken.findByTimemodified", query = "SELECT u FROM Usertoken u WHERE u.timemodified = :timemodified")})
public class Usertoken implements Serializable {
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
    @JoinColumn(name = "appuserid", referencedColumnName = "appuserid")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Appuser appuserid;

    public Usertoken() {
    }

    public Usertoken(Integer tokenid) {
        this.tokenid = tokenid;
    }

    public Usertoken(Integer tokenid, String seriesid, String token, Date datecreated, Date timemodified) {
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

    public Appuser getAppuserid() {
        return appuserid;
    }

    public void setAppuserid(Appuser appuserid) {
        this.appuserid = appuserid;
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
        if (!(object instanceof Usertoken)) {
            return false;
        }
        Usertoken other = (Usertoken) object;
        if ((this.tokenid == null && other.tokenid != null) || (this.tokenid != null && !this.tokenid.equals(other.tokenid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.authsvc.pu.entities.Usertoken[ tokenid=" + tokenid + " ]";
    }

}
