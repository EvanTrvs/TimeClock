package serial;

import java.time.LocalDateTime;
import java.util.ArrayList;

class UDPClient extends UDPClientBuilder implements Runnable {
	ArrayList<Timeclock> toSend;

	public UDPClient()
	{
		toSend = new ArrayList<>();
	}
	public void run() {

	}

	private void sendSocket(Timeclock element) {
		toSend.add(element);
		int send = 0;
		try {
			for (Timeclock timeclock : toSend)
			{
				setConnection();
				req = getSendingPacket(isA, 2028);
				setMsg(req, timeclock);
				s.send(req);
				s.close();	
				send++;			
			}

		} catch (Exception e) {			
			for(int i= 0;i<send;i++)
			{
				toSend.remove(0);
			}
		}	
	}

	public void Ping( int id) {
		LocalDateTime time = LocalDateTime.now();
		int min = time.getMinute();
		int b= (int) Math.round(  (double)min /(double)4)*15;
		if (b ==60)
		{
			b=0;
			time.plusHours(1);
		}
		time.withMinute(b);
		sendSocket(new Timeclock(id,time));
	}

	
	
}
