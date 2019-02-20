package knowledge.accumulation.springcloud.domain.mediator;

public interface Mediator {

    void register(String name,Department department);

    void command(String name);
}
