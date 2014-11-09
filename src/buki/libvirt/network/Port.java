package buki.libvirt.network;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root
public class Port {
	@Attribute
	public int start;
	
	@Attribute
	public int end;
	
}
