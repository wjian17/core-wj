package knowledge.accumulation.springcloud.domain.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> list = new ArrayList<>();

    public void register(Observer observer){
        list.add(observer);
    }

    public void remove(Observer observer){
        list.remove(observer);
    }

    public void notifyObserver(){
        for(Observer observer:list){
            observer.update(this);
        }
    }
}
