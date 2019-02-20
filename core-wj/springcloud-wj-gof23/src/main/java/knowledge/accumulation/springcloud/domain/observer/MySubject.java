package knowledge.accumulation.springcloud.domain.observer;

import java.util.Observable;

public class MySubject extends Observable {

    private int state;

    private void setState(int state){
        this.state = state;
        setChanged();//表示目标对象发生变更
        notifyObservers();//通知观察者变化
    }

    public int getState() {
        return state;
    }

    public static void main(String[] args) {
        MySubject mySubject = new MySubject();
        ObserverChild observerChild1 = new ObserverChild();
        ObserverChild observerChild2 = new ObserverChild();
        ObserverChild observerChild3 = new ObserverChild();
        mySubject.addObserver(observerChild1);
        mySubject.addObserver(observerChild2);
        mySubject.addObserver(observerChild3);
        mySubject.setState(200);
        System.out.println(observerChild1.getState());
        System.out.println(observerChild2.getState());
        System.out.println(observerChild3.getState());
    }
}
