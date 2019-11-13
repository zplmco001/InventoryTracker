package Model;
public class Product {
    private int id;
    private String description;
    private float price;
    private int quantity;
    private String name;

    public Product(int id, String des, float price,
                   int quantity, String name){
        this.description = des;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
