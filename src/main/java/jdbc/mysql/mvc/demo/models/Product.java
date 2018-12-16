package jdbc.mysql.mvc.demo.models;

public class Product {

    private int productId;
    private String name;
    private String title;
    private String price;
    private Boolean inStock;
    private Boolean isActive;
    private String category;
    private String imageUrl;

    public Product() {
    }

    public Product(int productId, String name, String title, String price, Boolean inStock, Boolean isActive, String category, String imageUrl) {
        this.productId = productId;
        this.name = name;
        this.title = title;
        this.price = price;
        this.inStock = inStock;
        this.isActive = isActive;
        this.category = category;
        this.imageUrl = imageUrl;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", inStock=" + inStock +
                ", isActive=" + isActive +
                ", category='" + category + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
