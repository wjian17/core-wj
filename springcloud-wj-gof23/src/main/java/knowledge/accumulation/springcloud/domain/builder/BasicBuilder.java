package knowledge.accumulation.springcloud.domain.builder;

import knowledge.accumulation.springcloud.domain.factory.Item;
import knowledge.accumulation.springcloud.domain.factory.Item_a;
import knowledge.accumulation.springcloud.domain.factory.Item_b;

public interface BasicBuilder {

    Item createItem();

    Item_a createItem_a();

    Item_b createItem_b();
}
