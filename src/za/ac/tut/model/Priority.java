package za.ac.tut.model;

public class Priority {
    // Enum for ticket priority with simple names
    public enum Level {
        LOW,
        MEDIUM,
        HIGH,
        CRITICAL
    }
    
    private int priorityId;
    private String priorityName;
    private int slaTime;
    
    public Priority(int priorityId, String priorityName, int slaTime) {
        this.priorityId = priorityId;
        this.priorityName = priorityName;
        this.slaTime = slaTime;
    }
    
    public Priority(String priorityName, int sla){
        this.priorityName = priorityName;
        this.slaTime = sla;
    }
    
    public Priority(String name){
        this.priorityName = name;
    }
    
    // Getters and Setters

    public int getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(int priorityId) {
        this.priorityId = priorityId;
    }

    public String getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
    }

    public int getSlaTime() {
        return slaTime;
    }

    public void setSlaTime(int slaTime) {
        this.slaTime = slaTime;
    }
}
