package serial;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

class UDPServerBuilder extends UDPREmpty{
	InetSocketAddress isA;
	DatagramSocket s;
	DatagramPacket req, rep;
	final int size = 2048;

	UDPServerBuilder() {
		isA = null;
		s = null;
		req = rep = null;
	}

	protected void setConnection() throws IOException {
		isA = new InetSocketAddress("localhost", 8085);
		s = new DatagramSocket(isA.getPort());
		/** we can include more setting, later … */
	}
}
