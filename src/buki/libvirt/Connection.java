package buki.libvirt;

import java.util.ArrayList;
import java.util.List;

import org.libvirt.Connect;
import org.libvirt.LibvirtException;

import buki.libvirt.network.Interface;
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
	
	public List<Network> getNetworks(){
		ArrayList<Network> networks = new ArrayList<>();
		try {
			String names[] = libvirtConn.listNetworks();
			for(String name: names ) {
				org.libvirt.Network nn = libvirtConn.networkLookupByName(name);
				Network newNetwork = Utils.fromXML(nn.getXMLDesc(0), Network.class);
				networks.add(newNetwork);
			}
		} catch(LibvirtException ex){
			ex.printStackTrace();
			return null;
		}
		return networks;
	}

	
	public List<Interface> getInterfaces(){
		ArrayList<Interface> interfaces = new ArrayList<>();
		try {
			String names[] = libvirtConn.listInterfaces();
			for(String name: names ) {
				org.libvirt.Interface nn = libvirtConn.interfaceLookupByName(name);
				Interface newIface = Utils.fromXML(nn.getXMLDescription(0), Interface.class);
				interfaces.add(newIface);
			}
		} catch(LibvirtException ex){
			ex.printStackTrace();
			return null;
		}
		return interfaces;
	}
}
