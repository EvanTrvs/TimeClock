package packaging;

public enum Day{
	MONDAY,TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
	
	public static int GetId(Day day)
	{
		if (day==Day.MONDAY)
		{
			return 0;
		}
		return 1;
	}
}