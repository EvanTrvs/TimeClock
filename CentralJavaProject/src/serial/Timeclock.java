package serial;

import java.io.Serializable;
import java.time.LocalTime;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

class Timeclock implements Serializable {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private int id;
		private LocalTime time;
		public Timeclock(int id)
		{
			this.id = id;

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
		public LocalTime getTime() {
			return time;
		}
		public void setTime(LocalTime time) {
			this.time = time;
		}
}