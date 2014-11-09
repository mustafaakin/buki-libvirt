package buki.libvirt.domain;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class Source {
	@Attribute(required=false)
	public String file;
}
