package knowledge.accumulation.springcloud.domain.proxy;

public class RealRole implements VisualRole{


    @Override
    public void bussiness() {
        System.out.println("realRole is doing bussiness");
    }

    @Override
    public void init() {

    }

    @Override
    public void destory() {

    }
}
