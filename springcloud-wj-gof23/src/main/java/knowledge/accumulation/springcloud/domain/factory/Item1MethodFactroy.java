package knowledge.accumulation.springcloud.domain.factory;

public class Item1MethodFactroy implements MethodFactory {
    @Override
    public Item createItem() {
        return new Item1();
    }
}
