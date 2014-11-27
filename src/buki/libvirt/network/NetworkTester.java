package buki.libvirt.network;

import java.util.List;

import buki.libvirt.Connection;
import buki.libvirt.Utils;

public class NetworkTester {
	public static void main(String[] args) throws Exception {		
		Connection connection = new Connection("qemu+tcp://192.168.1.3:16509/system");		
		
		// Network network = new Network("myothernetwork","em1","virbr2","15.15.15.1","255.255.255.0", "15.15.15.120","15.15.15.255");
		List<Network> networks = connection.getNetworks(true);
		for(Network n: networks){
			String s = Utils.toXML(n);
			System.out.println(s);
			
		}
		

	}
}
