package buki.libvirt.network;

import java.io.StringWriter;

import org.libvirt.Connect;
import org.libvirt.ConnectAuth;
import org.libvirt.ConnectAuthDefault;
import org.libvirt.ConnectAuth.CredentialType;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import buki.libvirt.Connection;
import buki.libvirt.Utils;

public class NetworkTester {
	public static void main(String[] args) throws Exception {		
		Network network = new Network("myothernetwork","virbr2","15.15.15.1","255.255.255.0", "15.15.15.120","15.15.15.255");
		
		Connection connection = new Connection("qemu+tcp://192.168.1.3:16509/system");		
		Network newNetwork = connection.createNetwork(network);
		
		String s = Utils.toXML(newNetwork);
		System.out.println(s);

	}
}
