package knowledge.accumulation.springcloud.domain.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义聚合类
 */
public class ConcreteMyAggregate {

    private List<Object> list = new ArrayList<>();

    public ConcreteMyAggregate(){

    }

    public void addObject(Object object){
        this.list.add(object);
    }

    public void removeObject(Object object){
        this.list.remove(object);
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }


    public static void main(String[] args) {
        ConcreteMyAggregate concreteMyAggregate = new ConcreteMyAggregate();
        concreteMyAggregate.addObject("aa");
        concreteMyAggregate.addObject("bb");
        concreteMyAggregate.addObject("cc");
        MyIterator myIterator = concreteMyAggregate.new ConcreteIterator();
        while (myIterator.hasNext()){
            System.out.println(myIterator.getCurrentObj());
            myIterator.next();
        }
    }

    private class ConcreteIterator implements MyIterator{

        private int cursor;//定义游标

        @Override
        public void first() {
            this.cursor = 0;
        }

        @Override
        public void next() {
            if(cursor<list.size()){
                cursor++;
            }
        }

        @Override
        public boolean hasNext() {
            if(cursor<list.size()){
                return true;
            }
            return false;
        }

        @Override
        public boolean isFirst() {
            return cursor==0?true:false;
        }

        @Override
        public boolean isLast() {
            return cursor==list.size()-1?true:false;
        }

        @Override
        public Object getCurrentObj() {
            return list.get(cursor);
        }
    }
}
