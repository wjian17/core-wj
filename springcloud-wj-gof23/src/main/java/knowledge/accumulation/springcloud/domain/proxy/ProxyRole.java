package knowledge.accumulation.springcloud.domain.proxy;

public class ProxyRole implements VisualRole{

    private VisualRole visualRole;

    @Override
    public void bussiness() {
        visualRole.bussiness();
    }

    @Override
    public void init() {
        System.out.println("ProxyRole running init()");
    }

    @Override
    public void destory() {
        System.out.println("ProxyRole running destory()");
    }

    public ProxyRole(VisualRole visualRole){
        this.visualRole = visualRole;
    }

    public static void main(String[] args) {
        VisualRole realRole = new RealRole();
        VisualRole proxyRole = new ProxyRole(realRole);
        proxyRole.init();
        proxyRole.bussiness();
        proxyRole.destory();
    }
}
