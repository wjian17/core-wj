package knowledge.accumulation.springcloud.domain.chain;

import lombok.Data;

@Data
public class LeaveRequest {

    private int leaveDays;

    public static void main(String[] args) {
        Leader manager = new Manager("manager");
        Leader director = new Director("director");
        director.setNextLeader(manager);
        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setLeaveDays(2);
        director.handleRequest(leaveRequest);
    }

}
