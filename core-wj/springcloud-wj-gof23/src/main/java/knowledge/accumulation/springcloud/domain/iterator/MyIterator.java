package knowledge.accumulation.springcloud.domain.iterator;

public interface MyIterator {

    void first(); //游标指向第一个元素
    void next();

    boolean hasNext();

    boolean isFirst();

    boolean isLast();

    Object getCurrentObj();

}
