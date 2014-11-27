package buki.libvirt.network;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class Interface {
	@Attribute
	String type;
	
	@Attribute
	String name;
		
	@Element(required=false)
	MAC mac;
	
	@ElementList(inline = true, required=false)
	public List<Protocol> protocol = new ArrayList<Protocol>();
	
}
