package knowledge.accumulation.springcloud.domain.builder;

import knowledge.accumulation.springcloud.domain.factory.*;

public class Product1Builder implements BasicBuilder {
    @Override
    public Item createItem() {
        return new Item1();
    }

    @Override
    public Item_a createItem_a() {
        return new Item_a1();
    }

    @Override
    public Item_b createItem_b() {
        return new Item_b1();
    }
}
