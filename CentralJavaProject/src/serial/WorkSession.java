package serial;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
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
		return start.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
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