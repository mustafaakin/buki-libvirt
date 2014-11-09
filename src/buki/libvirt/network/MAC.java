package buki.libvirt.network;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class MAC {
	@Attribute
	public String address;
	
	public MAC(String address){
		this.address = address;		
	}
	
	public MAC(){
		
	}
}
