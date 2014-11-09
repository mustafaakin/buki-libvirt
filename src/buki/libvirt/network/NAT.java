package buki.libvirt.network;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class NAT {
	@Element
	public Port port;
}
