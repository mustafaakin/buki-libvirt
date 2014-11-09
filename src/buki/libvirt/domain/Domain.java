package buki.libvirt.domain;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Domain {
	@Attribute
	public String type;

	@Element
	public String name;

	@Element(required = false)
	public String uuid;

	@Element
	public int memory;

	@Element
	public int currentMemory;
	
	@Element
	public int vcpu;
	
	@Element
	public OS os;

	@Element
	public Devices devices = new Devices();
}
