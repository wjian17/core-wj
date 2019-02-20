package knowledge.accumulation.springcloud.domain.command;

public interface Command {

    void execute();
}

class ConcreteCommand implements Command{

    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
