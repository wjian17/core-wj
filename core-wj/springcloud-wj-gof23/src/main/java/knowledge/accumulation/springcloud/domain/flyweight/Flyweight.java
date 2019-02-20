package knowledge.accumulation.springcloud.domain.flyweight;

public interface Flyweight {

    void setColor(String color);

    String getColor();

    void display(Coordinate coordinate);
}


class ConcreteChess implements Flyweight{

    private String color;//为内部状态提供字段存储

    public ConcreteChess(String color){
        super();
        this.color = color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public void display(Coordinate coordinate) {
        System.out.println(this.color);
        System.out.println(coordinate.getX()+"===="+coordinate.getY());
    }
}