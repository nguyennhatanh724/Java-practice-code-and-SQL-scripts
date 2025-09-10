
/**
 * Domain model representing a product in the system.
 * Contain attributes: id, name, price.
 */
public class Product {
    private int id;
    private String name;
    private double price;

    /**
     * Default constructors for creating an empty Product.
     */
    public Product() {
    }

    /**
     * Constructs a new Product with the given attributes.
     *
     * @param id    unique identifier of the product
     * @param name  product name
     * @param price product proce
     */
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return a string representation of product including id, name, price
     */
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
    }
}
