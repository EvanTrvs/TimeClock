package serial;

import java.time.LocalTime;

class UDPClientHello extends UDPClientBuilder implements Runnable {
	private boolean running;
	private FIFO fifo;
	public void run() {
		running = true;
		try {
			while (running)
			{
		        while (!fifo.isEmpty()) {
		        	Timeclock element = fifo.dequeue();
		            
		            sendSocket(element);
		        }
			}

		} catch (Exception e) {
			System.out.println("IOException UDPClient");
		}
	}

	private void sendSocket(Timeclock element) {
		try {
			setConnection();
			req = getSendingPacket(isA, 2028);
			setMsg(req, element);
			s.send(req);
			s.close();
		} catch (Exception e) {			
			e.printStackTrace();
		}	
	}

	public void Ping( int id) {
		LocalTime time = LocalTime.now();
		int min = time.getMinute();
        float div= (float)min /(float)15;
        int v = Math.round(div);       
        
		int b= (int) Math.round(  (double)time.getMinute()  /(double)4)*15;
		
		 fifo.enqueue(new Timeclock(id));
	}

	public boolean getRunning() {
		return running;
	}
	
	
}
