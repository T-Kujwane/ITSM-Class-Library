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
    private String priorityLevel;
    private int slaTime;
    
    public Priority(int priorityId, String priorityLevel, int slaTime) {
        this.priorityId = priorityId;
        this.priorityLevel = priorityLevel;
        this.slaTime = slaTime;
    }
    
    public Priority(String priorityLevel, int sla){
        this.priorityLevel = priorityLevel;
        this.slaTime = sla;
    }
    
    public Priority(String name){
        this.priorityLevel = name;
    }
    
    // Getters and Setters

    public int getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(int priorityId) {
        this.priorityId = priorityId;
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public int getSlaTime() {
        return slaTime;
    }

    public void setSlaTime(int slaTime) {
        this.slaTime = slaTime;
    }
}
