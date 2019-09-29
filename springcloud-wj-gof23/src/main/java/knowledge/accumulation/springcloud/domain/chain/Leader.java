package knowledge.accumulation.springcloud.domain.chain;

public abstract class Leader {

    protected String name;
    protected Leader nextLeader;

    public Leader(String name) {
        this.name = name;
    }

    public void setNextLeader(Leader nextLeader){
        this.nextLeader = nextLeader;
    }

    public abstract void handleRequest(LeaveRequest leaveRequest);
}
