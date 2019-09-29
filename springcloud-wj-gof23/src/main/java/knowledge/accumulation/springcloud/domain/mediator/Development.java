package knowledge.accumulation.springcloud.domain.mediator;

public class Development implements Department {

    private Mediator mediator;

    public Development(Mediator mediator){
        this.mediator = mediator;
        this.mediator.register("development",this);
    }
    @Override
    public void selfAction() {
        System.out.println("内部接口");
    }

    @Override
    public void outAction() {
        System.out.println("外部接口");
    }
}
