package buki.libvirt;

import org.libvirt.Connect;
import org.libvirt.LibvirtException;

import buki.libvirt.network.Network;

public class Connection {
	private String connectionURI;
	private Connect libvirtConn;

	public Connection(String connectionURI) {
		this.connectionURI = connectionURI;
		try {
			libvirtConn = new Connect(connectionURI);
		} catch (LibvirtException ex) {
			// Not sure what to do now
			ex.printStackTrace();
		}
	}		

	public Network createNetwork(Network network) {
		String xml = Utils.toXML(network);
		try {
			org.libvirt.Network nn = libvirtConn.networkCreateXML(xml);
			Network newNetwork = Utils.fromXML(nn.getXMLDesc(0), Network.class);
			return newNetwork;
		} catch (LibvirtException ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
