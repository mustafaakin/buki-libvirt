package buki.libvirt.network;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false, name = "ip")
public class IP {
	@Attribute
	public String address;
	@Attribute(required = false)
	public String netmask;

	@Attribute(required = false)
	public String prefix;

	@Element(required = false)
	public DHCP dhcp;
}
