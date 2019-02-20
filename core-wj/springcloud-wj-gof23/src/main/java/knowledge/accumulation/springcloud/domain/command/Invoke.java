package knowledge.accumulation.springcloud.domain.command;

public class Invoke {

    private Command command;

    public Invoke(Command command) {
        this.command = command;
    }

    public void call(){
        command.execute();
    }

    public static void main(String[] args) {
        Command command = new ConcreteCommand(new Receiver() {
            @Override
            public void action() {
                System.out.println("receiver doing");
            }
        });

        Invoke invoke = new Invoke(command);
        invoke.call();
    }
}
