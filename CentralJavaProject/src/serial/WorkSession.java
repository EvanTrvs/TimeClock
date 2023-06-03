package serial;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.MinguoDate;
import java.time.temporal.ChronoUnit;

public class WorkSession{
	LocalDateTime start;

	LocalDateTime end;
	
	public WorkSession(LocalDateTime now) {
		start = now;
	}
	public LocalDate getDate() {
		return start.toLocalDate();
	}
	
	public int getWeek()
	{
		return 1;
	}
	
	public LocalDateTime getStart() {
		return start;
	}
	public void setStart(LocalDateTime start) {
		this.start = start;
	}
	public LocalDateTime getEnd() {
		return end;
	}
	public void setEnd(LocalDateTime end) {
		this.end = end;
	}
    public int getDuration() {
        return (int)start.until(end,ChronoUnit.MINUTES) ;
	}
}