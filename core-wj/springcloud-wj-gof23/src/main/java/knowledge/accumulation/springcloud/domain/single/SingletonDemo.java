package knowledge.accumulation.springcloud.domain.single;

public class SingletonDemo {

    private SingletonDemo() {
        System.out.println("primary");
    }

    static class SingletonDemoItem{

        private static SingletonDemo singletonDemo = new SingletonDemo();
    }

    public static SingletonDemo getSingletonDemo(){
        return SingletonDemoItem.singletonDemo;
    }

    public static void main(String[] args) {
        SingletonDemo.getSingletonDemo();
    }
}
