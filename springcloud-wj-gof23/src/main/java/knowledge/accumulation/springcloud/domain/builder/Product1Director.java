package knowledge.accumulation.springcloud.domain.builder;

import knowledge.accumulation.springcloud.domain.factory.Item;
import knowledge.accumulation.springcloud.domain.factory.Item_a;
import knowledge.accumulation.springcloud.domain.factory.Item_b;

public class Product1Director implements BasicDirector {

    private BasicBuilder basicBuilder;

    public Product1Director(BasicBuilder basicBuilder) {
        this.basicBuilder = basicBuilder;
    }

    @Override
    public Product buildProduct() {
        Product product = new Product();
        Item item = basicBuilder.createItem();
        Item_a item_a = basicBuilder.createItem_a();
        Item_b item_b = basicBuilder.createItem_b();
        product.setItem(item);
        product.setItem_a(item_a);
        product.setItem_b(item_b);
        return null;
    }
}
