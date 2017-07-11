package com.authsvc.pu.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @(#)Appuser.java   17-Jan-2015 10:45:51
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
@Table(name = "appuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appuser.findAll", query = "SELECT a FROM Appuser a"),
    @NamedQuery(name = "Appuser.findByAppuserid", query = "SELECT a FROM Appuser a WHERE a.appuserid = :appuserid"),
    @NamedQuery(name = "Appuser.findByEmailaddress", query = "SELECT a FROM Appuser a WHERE a.emailaddress = :emailaddress"),
    @NamedQuery(name = "Appuser.findByPassword", query = "SELECT a FROM Appuser a WHERE a.password = :password"),
    @NamedQuery(name = "Appuser.findByUsername", query = "SELECT a FROM Appuser a WHERE a.username = :username"),
    @NamedQuery(name = "Appuser.findByDatecreated", query = "SELECT a FROM Appuser a WHERE a.datecreated = :datecreated"),
    @NamedQuery(name = "Appuser.findByTimemodified", query = "SELECT a FROM Appuser a WHERE a.timemodified = :timemodified")})
public class Appuser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "appuserid")
    private Integer appuserid;
    @Basic(optional = false)
    @Column(name = "emailaddress")
    private String emailaddress;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;
    @Basic(optional = false)
    @Column(name = "timemodified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timemodified;
    @JoinColumn(name = "appid", referencedColumnName = "appid")
    @ManyToOne(optional = false)
    private App appid;
    @JoinColumn(name = "userstatus", referencedColumnName = "userstatusid")
    @ManyToOne(optional = false)
    private Userstatus userstatus;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "appuserid")
    private Usertoken usertoken;

    public Appuser() {
    }

    public Appuser(Integer appuserid) {
        this.appuserid = appuserid;
    }

    public Appuser(Integer appuserid, String emailaddress, String password, String username, Date datecreated, Date timemodified) {
        this.appuserid = appuserid;
        this.emailaddress = emailaddress;
        this.password = password;
        this.username = username;
        this.datecreated = datecreated;
        this.timemodified = timemodified;
    }

    public Integer getAppuserid() {
        return appuserid;
    }

    public void setAppuserid(Integer appuserid) {
        this.appuserid = appuserid;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Userstatus getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(Userstatus userstatus) {
        this.userstatus = userstatus;
    }

    public Usertoken getUsertoken() {
        return usertoken;
    }

    public void setUsertoken(Usertoken usertoken) {
        this.usertoken = usertoken;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appuserid != null ? appuserid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appuser)) {
            return false;
        }
        Appuser other = (Appuser) object;
        if ((this.appuserid == null && other.appuserid != null) || (this.appuserid != null && !this.appuserid.equals(other.appuserid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.authsvc.pu.entities.Appuser[ appuserid=" + appuserid + " ]";
    }

}
