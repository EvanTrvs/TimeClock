package serial;

import java.io.IOException;
import java.net.DatagramPacket;
import java.util.ArrayList;

class UDPServer extends UDPServerBuilder implements Runnable {
	ArrayList<Timeclock> recu;
	public void run() {
		try {

			setConnection();
			System.out.println("ready");
			//s.setSoTimeout(500);
			DatagramPacket req;
			while (true) {
				req = new DatagramPacket(new byte[size], size);
				s.receive(req);

				System.out.println("request received");

				byte[] data = req.getData();
				Timeclock reception = (Timeclock) Timeclock.deserialize(data);
				
				System.out.println("Recu : ");
				System.out.println(reception.getterId());
				Reception(reception);
				if (reception.getterId() == 9) {
					break;
				}

				rep = new DatagramPacket(new byte[size], 0, size, req.getSocketAddress());
				s.send(rep);

				System.out.println("reply sent");
			}
			;

			s.close();

		} catch (IOException e) {
			System.out.println("IOException UDPServer");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	void Reception(Timeclock elem)
	{
		//to Override
	}

}