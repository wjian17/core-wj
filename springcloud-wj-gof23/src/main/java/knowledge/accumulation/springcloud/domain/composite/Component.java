package knowledge.accumulation.springcloud.domain.composite;

public interface Component {
}

interface Leaf extends Component{

}

interface Composite extends Component{
    void add(Component c);
    void remove(Component c);
    Component getComponent(int index);
}
