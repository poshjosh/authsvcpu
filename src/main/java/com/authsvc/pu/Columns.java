package com.authsvc.pu;


/**
 * @(#)Columns.java   19-Jan-2015 18:12:58
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
public interface Columns {
    
    public static enum App{appid, emailaddress, 
    password, username, userstatus, datecreated, timemodified}
    
    public static enum Apptoken{
        tokenid, appid, seriesid, token, 
        datecreated, timemodified}
    
    public static enum Appuser{appuserid, appid, emailaddress, 
    password, username, userstatus, datecreated, timemodified}
    
    public static enum Usertoken{
        tokenid, appuserid, seriesid, token, 
        datecreated, timemodified}
}
