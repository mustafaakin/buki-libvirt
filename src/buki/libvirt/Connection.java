package buki.libvirt;

import java.util.ArrayList;
import java.util.List;

import org.libvirt.Connect;
import org.libvirt.LibvirtException;
import org.libvirt.NodeInfo;

import buki.libvirt.domain.Domain;
import buki.libvirt.network.Interface;
import buki.libvirt.network.Network;

public class Connection {
	private String connectionURI;
	private volatile Connect libvirtConn;

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

	public List<Network> getNetworks(boolean isActive) {
		ArrayList<Network> networks = new ArrayList<>();
		try {
			String names[] = isActive ? libvirtConn.listNetworks()
					: libvirtConn.listDefinedNetworks();
			for (String name : names) {
				org.libvirt.Network nn = libvirtConn.networkLookupByName(name);
				Network newNetwork = Utils.fromXML(nn.getXMLDesc(0),
						Network.class);
				newNetwork.isActive = isActive;
				networks.add(newNetwork);
			}
		} catch (LibvirtException ex) {
			ex.printStackTrace();
			return null;
		}
		return networks;
	}

	public List<Interface> getInterfaces(boolean isActive) {
		ArrayList<Interface> interfaces = new ArrayList<>();
		try {
			String names[] = isActive ? libvirtConn.listInterfaces()
					: libvirtConn.listDefinedInterfaces();
			for (String name : names) {
				org.libvirt.Interface nn = libvirtConn
						.interfaceLookupByName(name);
				Interface newIface = Utils.fromXML(nn.getXMLDescription(0),
						Interface.class);
				newIface.isActive = isActive;
				interfaces.add(newIface);
			}
		} catch (LibvirtException ex) {
			ex.printStackTrace();
			return null;
		}
		return interfaces;
	}

	public List<Domain> getDomains(boolean isActive) {
		ArrayList<Domain> domains = new ArrayList<>();
		try {
			if (isActive) {
				int ids[] = libvirtConn.listDomains();
				for (int id : ids) {
					org.libvirt.Domain nn = libvirtConn.domainLookupByID(id);
					Domain newDomain = Utils.fromXML(nn.getXMLDesc(0),
							Domain.class);
					newDomain.isActive = isActive;
					domains.add(newDomain);
				}
			} else {
				String doms[] = libvirtConn.listDefinedDomains();
				for (String domain : doms) {
					org.libvirt.Domain nn = libvirtConn
							.domainLookupByName(domain);
					Domain newDomain = Utils.fromXML(nn.getXMLDesc(0),
							Domain.class);
					newDomain.isActive = isActive;
					domains.add(newDomain);
				}
			}
		} catch (LibvirtException ex) {
			ex.printStackTrace();
			return null;
		}
		return domains;
	}

	public NodeInfo getNodeInfo() {
		try {
			return libvirtConn.nodeInfo();
		} catch (LibvirtException ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
