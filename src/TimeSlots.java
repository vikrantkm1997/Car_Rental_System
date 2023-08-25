import javax.swing.plaf.PanelUI;

public class TimeSlots {
    private int startTime;
    private int endTime;

    public TimeSlots(int startTime,int endTime)
    {
        this.startTime= startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
