package serial;
import static java.time.temporal.ChronoUnit.MINUTES;

import java.time.LocalTime;

public class Session {
	private LocalTime start;
	private LocalTime end;
	
	
	public Session()
	{

		start = null;
		end = null;
	}
	
	public LocalTime getStart() {
		return start;
	}

	public void setStart(LocalTime start) {
		this.start = start;
	}
	public LocalTime getEnd() {
		return end;
	}
	public void setEnd(LocalTime end) {
		this.end = end;
	}
	
	public long getDuration() throws Exception
	{
		if (end == null)
		{
			throw new Exception("The session is not end");
		}
		else 
		{
			return start.until(end,MINUTES);
			
		}
	}
	
	public boolean isFinish()
	{
		return (end != null);
	}

}