package buki.libvirt.network;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class Forward {
	@Attribute
	public String mode;

	@Attribute(required=false)
	public String dev;
	
	@Element(required=false)
	public NAT nat;
}
