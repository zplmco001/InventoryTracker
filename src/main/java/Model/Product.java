package Model;
public class Product {


    private String productId;
    private String productName;
    private String productQuantitiy;

    public Product(String productId, String productName, String productQuantitiy) {
        this.productId = productId;
        this.productName = productName;
        this.productQuantitiy = productQuantitiy;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductQuantitiy() {
        return productQuantitiy;
    }

    public void setProductQuantitiy(String productQuantitiy) {
        this.productQuantitiy = productQuantitiy;
    }
}
