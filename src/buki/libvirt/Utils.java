package buki.libvirt;

import java.io.StringWriter;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class Utils {
	public static String toXML(Object o){
		Serializer serializer = new Persister();
		StringWriter s = new StringWriter();
		try {
			serializer.write(o, s);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
		return s.toString();
	}
	
	public static <T> T fromXML(String str, Class<T> clazz){
		Serializer serializer = new Persister();
		try {
			T obj = serializer.read(clazz, str);
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}				
	}
}
