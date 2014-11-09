package buki.libvirt;

import org.libvirt.Connect;
import org.libvirt.Domain;
import org.libvirt.Network;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class Tester {

	public static void main(String[] args) throws Exception {
		Connect conn = new Connect("qemu+tcp://192.168.1.3:16509/system", true);
		boolean b = conn.isConnected();
		System.out.println("Connected: " + b);
		int[] domains = conn.listDomains();
		for (int domain : domains) {
			Domain d = conn.domainLookupByID(domain);
			String s = d.getXMLDesc(0);

			// System.out.println(s);
		}


		
		String[] networks = conn.listNetworks();
		for (String network : networks) {
			Network s = conn.networkLookupByName(network);
			String xml = s.getXMLDesc(0);
			System.out.println("XML: ***\n" + xml + "\n*****");

			Serializer serializer = new Persister();
			buki.libvirt.network.Network n = serializer.read(
					buki.libvirt.network.Network.class, xml);
			

		}

		
		
		
	}
}
