package buki.libvirt.domain;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class Target {
	@Attribute
	public String dev;
	
	@Attribute(required=false)
	public String bus;
}
