package buki.libvirt.network;

import java.io.StringWriter;

import org.libvirt.Connect;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class NetworkTester {
	public static void main(String[] args) throws Exception {
		System.out.println("Hello darling");
		
		Network n = new Network("myothernetwork","virbr2","15.15.15.1","255.255.255.0", "15.15.15.120","15.15.15.255");
		
		Serializer serializer = new Persister();
		StringWriter s = new StringWriter();
		
		serializer.write(n, s);

		System.out.println(s);

		Connect conn = new Connect("qemu+tcp://192.168.1.3:16509/system", false);
		boolean b = conn.isConnected();
		System.out.println("\nConnected: " + b);

		 conn.networkCreateXML(s.toString());

	}
}
