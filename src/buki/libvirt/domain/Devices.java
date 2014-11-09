package buki.libvirt.domain;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class Devices {
	@Element
	public String emulator;
	
	@ElementList(inline=true)
	public List<Disk> disk = new ArrayList<Disk>();	
}
