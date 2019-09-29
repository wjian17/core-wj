package knowledge.accumulation.springcloud.domain.builder;

import knowledge.accumulation.springcloud.domain.factory.Item;
import knowledge.accumulation.springcloud.domain.factory.Item_a;
import knowledge.accumulation.springcloud.domain.factory.Item_b;
import lombok.Data;

@Data
public class Product {

    private Item item;

    private Item_a item_a;

    private Item_b item_b;
}
