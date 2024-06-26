import java.util.ArrayList;
import java.util.List;

public final class Human extends Actor {
    private final List<EProduct> order;

    public Human(String name) {
        super(name);
        this.order = new ArrayList<>();  // Используем diamond operator
        setMakeOrder(false);
        setTakeOrder(false);
    }

    public Human(String name, List<EProduct> products) {
        super(name);
        this.order = new ArrayList<>(products);  // Используем diamond operator
        setMakeOrder(true);
        setTakeOrder(false);
    }

    @Override
    public void setMakeOrder(boolean flag) {
        this.isMakeOrder = flag;
    }

    @Override
    public void setTakeOrder(boolean flag) {
        this.isTakeOrder = flag;
    }

    @Override
    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    @Override
    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    @Override
    public String getName() {
        return name;
    }

    public void saveOrder(EProduct product) {
        order.add(product);
        setMakeOrder(true);
    }

    public void saveOrder(List<EProduct> products) {
        order.addAll(products);
        setMakeOrder(true);
    }

    @Override
    public String toString() {
        return name;
    }
}
