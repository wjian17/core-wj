package knowledge.accumulation.springcloud.domain.factory;

public class SimpleFactory {

    public Item buildItem(String itemType){
        Item item = null;
        switch (itemType){
            case "1":
                item = new Item1();
                break;
            case "2":
                item = new Item2();
                break;
        }
        return item;
    }

    public Item buildItem1(){
        return new Item1();
    }

    public Item buildItem2(){
        return new Item2();
    }
}
