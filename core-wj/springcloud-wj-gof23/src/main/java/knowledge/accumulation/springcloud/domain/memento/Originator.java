package knowledge.accumulation.springcloud.domain.memento;

import lombok.Data;

@Data
public class Originator {

    private String name;

    public Memento memento(){
        return new Memento(name);
    }

    public void recovery(Memento memento){
        this.name = memento.getName();
    }

}
