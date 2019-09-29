package knowledge.accumulation.springcloud.domain.mediator;

public class Finacial implements Department {

    private Mediator mediator;

    public Finacial(Mediator mediator){
        this.mediator = mediator;
        this.mediator.register("finacial",this);
    }
    @Override
    public void selfAction() {
        System.out.println("finacial 内部");
    }

    @Override
    public void outAction() {
        System.out.println("finacial 外部");
    }
}
