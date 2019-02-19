package knowledge.accumulation.springcloud.domain.single;

public class SingletonDomain {

    private static SingletonDomain singletonDomain = new SingletonDomain();

    private SingletonDomain() {

    }

    public SingletonDomain getSingletonDomain() {
        return singletonDomain;
    }
}

class SingletonDomain1 {

    private static SingletonDomain1 singletonDomain1;

    private SingletonDomain1() {

    }

    public synchronized SingletonDomain1 getSingletonDomain1() {
        if (singletonDomain1 == null) {
            singletonDomain1 = new SingletonDomain1();
        }
        return singletonDomain1;
    }

}

class SingletonDomain2 {

    private SingletonDomain2(){

    }

    /**
     * 内部类只有在调用时候才会加载 间接实现懒加载
     */
    public static class SingletonItem{
        private static SingletonDomain2 singletonDomain2= new SingletonDomain2();
    }

    public static SingletonDomain2 getInstance(){
        return SingletonItem.singletonDomain2;
    }
}

enum SingletonDomain3 {

    SingletonDomain3;

    public void SingletonDomain3() {

    }
}
