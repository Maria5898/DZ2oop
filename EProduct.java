public class EProduct {
    private String name;

    public EProduct(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product: " + name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
