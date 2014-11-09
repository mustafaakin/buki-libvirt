package buki.libvirt;

import org.libvirt.Connect;

import buki.libvirt.domain.Domain;

public class Tester2 {
	public static void main(String[] args) throws Exception {
		Connect conn = new Connect("qemu+tcp://192.168.1.3:16509/system", true);
		boolean b = conn.isConnected();
		System.out.println("Connected: " + b);
		int[] domains = conn.listDomains();
		for (int domain : domains) {
			String s = conn.domainLookupByID(domain).getXMLDesc(0);
			System.out.println(s);

			Domain d = Utils.fromXML(s, Domain.class);
			String newXML = Utils.toXML(d);
			System.out.println(newXML);
		}

	}
}
