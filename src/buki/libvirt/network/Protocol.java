package buki.libvirt.network;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Protocol {
	@Attribute
	String family;

	@Element
	IP ip;
}
