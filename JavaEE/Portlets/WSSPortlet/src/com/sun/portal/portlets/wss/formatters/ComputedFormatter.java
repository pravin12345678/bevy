/*
* Licensed to the Apache Software Foundation (ASF) under one
* or more contributor license agreements.  See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership.  The ASF licenses this file
* to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License.  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*
*
* Author Of This Original Software : Sandeep Soni [ Sandeep.Soni at gmail dot com ]
* With Active Contributions from Murali Krishna Reddy

* Do Let Me Know by Email if you used the software and found it useful.
*
*/
package com.sun.portal.portlets.wss.formatters;

import java.util.HashMap;

import com.sun.portal.portlets.wss.constants.Constants;
import com.sun.portal.portlets.wss.utils.UrlWrapper;

/**
 * Created by IntelliJ IDEA. User: root Date: Aug 30, 2006 Time: 5:03:22 PM To
 * change this template use File | Settings | File Templates.
 */
public class ComputedFormatter implements InterfaceFormatter {

    public String getFormattedValue(String listSoapAddress, String listName, String RootFolder, String fieldValue, String id) {

	// String modstr = "<a href=\"" + listSoapAddress + "/Lists/" + listName
        // + "/DispForm.aspx?ID=" + id + "\">" + fieldValue + "</a>";

	// System.out.println(modstr);
	// return modstr;

	return null;
    }

    public String getFormattedValue(String listSoapAddress, String listName, String RootFolder, String fieldValue, String id, HashMap formatterVariables) {
	String bodyView = (String) formatterVariables.get(Constants.WSS_BODYVIEW);

	if (!bodyView.equals("")) {
	    UrlWrapper url = (UrlWrapper) formatterVariables.get(Constants.WSS_PORTLET_URL);
	    url.setParameter("viewbody", bodyView);
	    url.setParameter("list", listName);
	    url.setParameter("id", id);
	    String link = "<a href=\"" + url.toString() + "\">" + fieldValue + "</a>";
	    return link;
	} else {
	    return fieldValue;
	}

    }

}