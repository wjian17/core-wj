package knowledge.accumulation.springcloud.domain.memento;

import lombok.Data;

@Data
public class CareTaker {

    private Memento memento;


    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();
        Originator originator = new Originator();
        originator.setName("nameORG");
        System.out.println(originator.getName());
        careTaker.setMemento(originator.memento());
        originator.setName("name_update");
        System.out.println(originator.getName());
        originator.recovery(careTaker.getMemento());
        System.out.println(originator.getName());

    }
}
