package knowledge.accumulation.springcloud.domain.chain;

public class Manager extends Leader {

    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest leaveRequest) {
        if(leaveRequest.getLeaveDays()<10){
            System.out.println("manager is detail");
        }else{
            System.out.println("error");
            if(this.nextLeader!=null){
                this.nextLeader.handleRequest(leaveRequest);
            }
        }
    }
}
