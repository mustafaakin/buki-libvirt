package buki.libvirt.domain;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class Disk {
	@Attribute
	public String type;
	
	@Attribute(required=false)
	public String device;
	
	@Element
	public Target target;
	
	@Element
	public Source source;
}
