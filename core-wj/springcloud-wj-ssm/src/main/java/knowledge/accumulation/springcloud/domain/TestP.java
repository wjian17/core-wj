package knowledge.accumulation.springcloud.domain;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("testP")
public abstract class TestP {

    public void process(){
        Object object = getBean();
        System.out.println(object);
    }

    @Lookup("children")
    public abstract Object getBean();
}
