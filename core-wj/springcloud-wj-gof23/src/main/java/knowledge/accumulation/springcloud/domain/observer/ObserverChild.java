package knowledge.accumulation.springcloud.domain.observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverChild implements Observer {

    private int state;

    @Override
    public void update(Observable o, Object arg) {
        MySubject mySubject = (MySubject)o;
        state = mySubject.getState();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
