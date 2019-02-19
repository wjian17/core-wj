package knowledge.accumulation.springcloud.domain.decorate;

import lombok.Data;

@Data
public class Decorator implements IDemo{

    private IDemo iDemo;

    public Decorator(IDemo iDemo){
        this.iDemo = iDemo;
    }

    @Override
    public void bussiness() {
        iDemo.bussiness();
    }

    public static void main(String[] args) {
        Decorator decorator_demo1 = new Decorator_Demo1(new realDemo());
        decorator_demo1.bussiness();
    }
}

class Decorator_Demo1 extends Decorator{

    public Decorator_Demo1(IDemo iDemo) {
        super(iDemo);
    }

    @Override
    public void bussiness() {
        System.out.println("111111");
        super.bussiness();
    }
}
class Decorator_Demo2 extends Decorator{

    public Decorator_Demo2(IDemo iDemo) {
        super(iDemo);
    }
}
class Decorator_Demo3 extends Decorator{

    public Decorator_Demo3(IDemo iDemo) {
        super(iDemo);
    }
}
