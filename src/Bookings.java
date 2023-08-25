import java.util.ArrayList;
import java.util.List;

public class Bookings {
    private List<TimeSlots> timeSlots;
    public Bookings()
    {
        timeSlots = new ArrayList<>();
    }

    public boolean checkAvailability(int startTime,int endTime){

        for(TimeSlots t:timeSlots)
        {
            if((t.getStartTime() >= startTime && t.getEndTime() >=startTime )||( t.getStartTime() >= endTime && t.getEndTime() >= endTime))
                return false;
        }

        return true;
    }
    public void addTimeSlots(int startTime,int endTime)
    {
        TimeSlots timeSlots1 = new TimeSlots(startTime,endTime);
        timeSlots.add(timeSlots1);
    }


}
