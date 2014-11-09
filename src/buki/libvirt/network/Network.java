package buki.libvirt.network;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Network {
	@Element
	public String name;
	
	@Element(required=false)
	public String uuid;
	@Element
	public Bridge bridge;
	@Element
	public Forward forward;

	@Element(required=false)
	public MAC mac;
	
	@Attribute(required=false)
	public String ipv6;
	
	@Attribute(required=false)
	public String trustGuestRxFilters;
		
	@ElementList(inline = true)
	public List<IP> ip = new ArrayList<IP>();
	
	
	public Network(){
		
	}
	
	public Network(String name, String bridgeName, String gateway, String netmask, String rangeStart, String rangeEnd){
		this.name = name;
		this.bridge = new Bridge();
		this.bridge.name = name;
		
		this.forward = new Forward();
		this.forward.mode = "nat";
				
		IP ip = new IP();
		ip.dhcp = new DHCP();
		ip.dhcp.range = new Range();
		ip.dhcp.range.start = rangeStart;
		ip.dhcp.range.end = rangeEnd;
		ip.address = gateway;
		ip.netmask = netmask;
		
		this.ip.add(ip);
	}
}
