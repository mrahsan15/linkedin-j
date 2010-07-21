/*
 * Copyright 2010 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */

package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Network;
import com.google.code.linkedinapi.schema.NetworkStats;
import com.google.code.linkedinapi.schema.Updates;

public class NetworkImpl
    extends BaseSchemaEntity
    implements Network
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 6143437997201279562L;
	protected NetworkStatsImpl networkStats;
    protected UpdatesImpl updates;

    public NetworkStats getNetworkStats() {
        return networkStats;
    }

    public void setNetworkStats(NetworkStats value) {
        this.networkStats = ((NetworkStatsImpl) value);
    }

    public Updates getUpdates() {
        return updates;
    }

    public void setUpdates(Updates value) {
        this.updates = ((UpdatesImpl) value);
    }

	@Override
	public void init(Element element) {
		Element networkStatsElem = (Element) DomUtils.getChildElementByName(element, "network-stats");
		if (networkStatsElem != null) {
			NetworkStatsImpl networkStatsImpl = new NetworkStatsImpl();
			networkStatsImpl.init(networkStatsElem);
			setNetworkStats(networkStatsImpl);
		}
		Element updateElem = (Element) DomUtils.getChildElementByName(element, "updates");
		if (updateElem != null) {
			UpdatesImpl updateImpl = new UpdatesImpl();
			updateImpl.init(updateElem);
			setUpdates(updateImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("network");
		if (getNetworkStats() != null) {
			element.appendChild(((NetworkStatsImpl) getNetworkStats()).toXml(document));
		}
		if (getUpdates() != null) {
			element.appendChild(((UpdatesImpl) getUpdates()).toXml(document));
		}
		return element;
	}
}
