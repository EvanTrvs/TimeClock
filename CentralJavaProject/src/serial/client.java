package serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;

class UDPClient extends UDPClientBuilder implements Runnable {
	ArrayList<Timeclock> toSend;

	public UDPClient()
	{
		
		try {
			getData();
		} catch (IOException e) {
			toSend = new ArrayList<>();
		}
	}

	public void finalize()
	{
		saveData();
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

	public void saveData() {
		try (FileOutputStream fos = new FileOutputStream("data2send");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			oos.writeObject(toSend);

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	@SuppressWarnings("unchecked") 
	public void getData() throws IOException{
		try (FileInputStream fis = new FileInputStream("data2send");
		    ObjectInputStream ois = new ObjectInputStream(fis);) {

		  toSend = (ArrayList<Timeclock>) ois.readObject();

		} catch (ClassNotFoundException c) {
		  System.out.println("Class not found");
		  c.printStackTrace();
		}

	}
	
}
