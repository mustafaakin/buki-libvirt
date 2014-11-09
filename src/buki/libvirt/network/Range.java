package buki.libvirt.network;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class Range {
	@Attribute
	public String start;
	
	@Attribute
	public String end;
}
