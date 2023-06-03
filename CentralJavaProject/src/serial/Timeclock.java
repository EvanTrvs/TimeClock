package serial;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Timeclock implements Serializable {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private int id;
		private LocalDateTime time;
		public Timeclock(int id,LocalDateTime time)
		{
			this.id = id;
			this.time = time;

		}
		public void Setterid(int id)
		{
			this.id= id;
		}
		
		public int getterId()
		{
			return id;
		}
	   public void display() {
	      System.out.println(id);
	   }
	   
	   
	   public byte[] Timeclock2bytes() throws Exception {
		      ByteArrayOutputStream bos = new ByteArrayOutputStream();
		      ObjectOutputStream oos = new ObjectOutputStream(bos);
		      oos.writeObject(this);
		      oos.flush();
		      return bos.toByteArray();
		   }
		public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
		    ByteArrayInputStream in = new ByteArrayInputStream(data);
		    ObjectInputStream is = new ObjectInputStream(in);
		    return is.readObject();
		}
		public LocalDateTime getTime() {
			return time;
		}
		public void setTime(LocalDateTime time) {
			this.time = time;
		}
}