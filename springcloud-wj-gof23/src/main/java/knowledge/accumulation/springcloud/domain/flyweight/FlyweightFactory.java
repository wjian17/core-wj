package knowledge.accumulation.springcloud.domain.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {

    private static Map<String,Flyweight> map = new HashMap<>();

    private static Flyweight getChess(String color){
        if(map.get(color)!=null){
            return map.get(color);
        }else{
            Flyweight flyweight = new ConcreteChess(color);
            map.put(color,flyweight);
            return flyweight;
        }
    }
}
