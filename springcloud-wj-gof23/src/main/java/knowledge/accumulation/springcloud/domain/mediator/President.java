package knowledge.accumulation.springcloud.domain.mediator;

import java.util.HashMap;
import java.util.Map;

public class President implements Mediator {

    private Map<String,Department> map = new HashMap<>();

    @Override
    public void register(String name, Department department) {
        map.put(name,department);
    }

    @Override
    public void command(String name) {
        map.get(name).selfAction();
    }

    public static void main(String[] args) {
        Mediator mediator = new President();
        Department development = new Development(mediator);
        Department finacial = new Finacial(mediator);
    }
}
