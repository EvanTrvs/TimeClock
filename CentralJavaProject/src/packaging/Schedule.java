package packaging;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class Schedule {
	//Attributes
	private DayOfWeek Day;
	
	private LocalTime Start;
	
	private LocalTime End;
	
	//Constructors
	public Schedule() {
		this(DayOfWeek.SUNDAY, LocalTime.MIDNIGHT, LocalTime.MIDNIGHT);
	}
	
	public Schedule(DayOfWeek day) {
		this(day, LocalTime.MIDNIGHT, LocalTime.MIDNIGHT);
	}
	
	public Schedule(DayOfWeek day, LocalTime start, LocalTime end) {
		this.setDay(day);
		this.setStart(start);
		this.setEnd(end);
	}

	//Methods
	public DayOfWeek getDay() {
		return Day;
	}

	public void setDay(DayOfWeek day) {
		Day = day;
	}

	public LocalTime getStart() {
		return Start;
	}

	public void setStart(LocalTime start) {
		Start = start;
	}

	public LocalTime getEnd() {
		return End;
	}

	public void setEnd(LocalTime end) {
		End = end;
	}
	
	public Duration workDuration() {
		return Duration.between(Start, End);
	}
}
