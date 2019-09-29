package knowledge.accumulation.springcloud.domain.memento;

import lombok.Data;

@Data
public class Memento {

    private String name;

    public Memento(String name) {
        this.name = name;
    }
}
