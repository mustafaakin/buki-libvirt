package buki.libvirt.network;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;


@Root(strict=false)
public class Bridge {
	@Attribute
	public String name;
}
