package serial;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class clientBuilder{
	InetSocketAddress isA;
	DatagramSocket s;
	DatagramPacket req, rep;
	final int size = 2048;

	clientBuilder() {
		isA = null;
		s = null;
		req = rep = null;
	}

	protected void setConnection() throws IOException {
		s = new DatagramSocket();
		isA = new InetSocketAddress("192.168.0.1", 8085);
		/** we can include more setting, later … */
	}
}
