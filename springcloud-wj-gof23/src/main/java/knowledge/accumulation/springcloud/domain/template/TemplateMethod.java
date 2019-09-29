package knowledge.accumulation.springcloud.domain.template;

public abstract class TemplateMethod {

    public void takeNumber(){
        System.out.println("number is padding");
    }

    public abstract void transaction();

    public void evalute(){
        System.out.println("ending");
    }

    public final void process(){
        this.takeNumber();
        this.transaction();
        this.evalute();
    }
}
