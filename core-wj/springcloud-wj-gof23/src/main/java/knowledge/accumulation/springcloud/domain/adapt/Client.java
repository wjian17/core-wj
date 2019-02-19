package knowledge.accumulation.springcloud.domain.adapt;

public class Client {

    public void doSomething(Target target){
        target.doSomeThing();
    }

    public static void main(String[] args) {

        Client client = new Client();
        Adapter adapter = new Adapter();
        Adapter1 adapter1 = new Adapter1();
        adapter1.setAdaptee(new Adaptee());
        client.doSomething(adapter);
        client.doSomething(adapter1);
    }
}
