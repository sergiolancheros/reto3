package Ciclo31.Ciclo31.Dummies;

public class StatusAmount {
    private int completed;
    private int cancelled;

    public int getCompleted() {
        return completed;
    }
    public void setCompleted(int completed) {
        this.completed = completed;
    }
    public int getCancelled() {
        return cancelled;
    }
    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }
    public StatusAmount(int completed, int cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    public StatusAmount(){
        
    }
    
}
