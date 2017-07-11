package com.authsvc.pu.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 * @(#)App.java   17-Jan-2015 10:45:51
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
@Table(name = "app")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "App.findAll", query = "SELECT a FROM App a"),
    @NamedQuery(name = "App.findByAppid", query = "SELECT a FROM App a WHERE a.appid = :appid"),
    @NamedQuery(name = "App.findByEmailaddress", query = "SELECT a FROM App a WHERE a.emailaddress = :emailaddress"),
    @NamedQuery(name = "App.findByPassword", query = "SELECT a FROM App a WHERE a.password = :password"),
    @NamedQuery(name = "App.findByUsername", query = "SELECT a FROM App a WHERE a.username = :username"),
    @NamedQuery(name = "App.findByDatecreated", query = "SELECT a FROM App a WHERE a.datecreated = :datecreated"),
    @NamedQuery(name = "App.findByTimemodified", query = "SELECT a FROM App a WHERE a.timemodified = :timemodified")})
public class App implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "appid")
    private Integer appid;
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
    @JoinColumn(name = "userstatus", referencedColumnName = "userstatusid")
    @ManyToOne(optional = false)
    private Userstatus userstatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appid")
    private List<Appuser> appuserList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "appid")
    private Apptoken apptoken;

    public App() {
    }

    public App(Integer appid) {
        this.appid = appid;
    }

    public App(Integer appid, String emailaddress, String password, String username, Date datecreated, Date timemodified) {
        this.appid = appid;
        this.emailaddress = emailaddress;
        this.password = password;
        this.username = username;
        this.datecreated = datecreated;
        this.timemodified = timemodified;
    }

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
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

    public Userstatus getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(Userstatus userstatus) {
        this.userstatus = userstatus;
    }

    @XmlTransient
    public List<Appuser> getAppuserList() {
        return appuserList;
    }

    public void setAppuserList(List<Appuser> appuserList) {
        this.appuserList = appuserList;
    }

    public Apptoken getApptoken() {
        return apptoken;
    }

    public void setApptoken(Apptoken apptoken) {
        this.apptoken = apptoken;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appid != null ? appid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof App)) {
            return false;
        }
        App other = (App) object;
        if ((this.appid == null && other.appid != null) || (this.appid != null && !this.appid.equals(other.appid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.authsvc.pu.entities.App[ appid=" + appid + " ]";
    }

}
