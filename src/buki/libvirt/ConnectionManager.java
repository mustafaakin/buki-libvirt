package buki.libvirt;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.libvirt.Connect;
import org.libvirt.LibvirtException;

public class ConnectionManager {

	public static class ConnectionHolder {
		private Connect connect;
		private Lock lock = new ReentrantLock();

		public Connect getConnect() {
			return connect;
		}
		
		public void release() {
			lock.unlock();
		}
	}

	private HashMap<String, ConnectionHolder> str = new HashMap<>();

	private static ConnectionManager instance = new ConnectionManager();

	private ConnectionManager() {
		// Singleton Pattern
	}

	public static ConnectionHolder getConnection(String hostname) {
		ConnectionHolder connHolder = instance.str.get(hostname);
		if (connHolder == null) {
			throw new IllegalArgumentException("The hostname is not known!: "
					+ hostname);
		}
		connHolder.lock.lock();
		return connHolder;
	}

	public static boolean addConnection(String hostname, String connectionString) {
		ConnectionHolder ch = new ConnectionHolder();
		try {
			ch.connect = new Connect(connectionString);
			instance.str.put(hostname, ch);
			System.out.println("Adding new connection: " + hostname + " - "
					+ connectionString);
		} catch (LibvirtException e) {
			System.out.println("Could not add a new connection: " + hostname + " - "
					+ connectionString + ": " + e.getMessage());
			return false;
		}
		return true;
	}

}
