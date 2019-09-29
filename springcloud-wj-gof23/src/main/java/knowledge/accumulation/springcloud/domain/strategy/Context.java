package knowledge.accumulation.springcloud.domain.strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public double pringPrice(double price){
        return this.strategy.getPrice(price);
    }
}
