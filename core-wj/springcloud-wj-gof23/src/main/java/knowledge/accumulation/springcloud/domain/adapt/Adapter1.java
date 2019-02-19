package knowledge.accumulation.springcloud.domain.adapt;

import lombok.Data;

@Data
public class Adapter1 implements Target {

    private Adaptee adaptee;

    @Override
    public void doSomeThing() {
        adaptee.doSomeThing();
    }
}
