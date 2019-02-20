package knowledge.accumulation.springcloud.domain.strategy;

public interface Strategy {

    public double getPrice(double standardPrice);
}

class Strategy1 implements Strategy{

    @Override
    public double getPrice(double standardPrice) {
        return 0;
    }
}
class Strategy2 implements Strategy{

    @Override
    public double getPrice(double standardPrice) {
        return 0;
    }
}