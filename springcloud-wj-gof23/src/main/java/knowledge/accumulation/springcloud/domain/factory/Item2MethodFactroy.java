package knowledge.accumulation.springcloud.domain.factory;

public class Item2MethodFactroy implements MethodFactory {
    @Override
    public Item createItem() {
        return new Item2();
    }
}
