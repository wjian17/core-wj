package knowledge.accumulation.springcloud.domain.chain;

public class Director extends Leader {


    public Director(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest leaveRequest) {
        if(leaveRequest.getLeaveDays()<3){
            System.out.println("director is detail");
        }else{
            if(this.nextLeader!=null){
                this.nextLeader.handleRequest(leaveRequest);
            }
        }
    }
}
