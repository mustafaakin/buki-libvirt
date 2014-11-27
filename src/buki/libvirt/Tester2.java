package buki.libvirt;

import org.libvirt.Connect;
import org.libvirt.Interface;

public class Tester2 {
	public static void main(String[] args) throws Exception {
		Connect conn = new Connect("qemu+tcp://192.168.1.3:16509/system", true);
		boolean b = conn.isConnected();
		System.out.println("Connected: " + b);

		String[] ifaces = conn.listInterfaces();
		for(String iface: ifaces){
			Interface i = conn.interfaceLookupByName(iface);
			String s = i.getXMLDescription(0);
			System.out.println(s);

			buki.libvirt.network.Interface myIface = Utils.fromXML(s, buki.libvirt.network.Interface.class);
	

		}
		
		
	}
}
