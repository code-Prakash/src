package models;

public class Product {
    private int id;
    private String productName;
    private double price;
    private String category;
    private int stock;
    private String description;

    public Product(int id, String productName, double price, String category, int stock, String description) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.description = description;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getProductName(){
        return productName;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        this.stock = stock;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @Override
    public String toString() {
        return "Product [id=" + id + ", Name=" + productName + ", Price=" + price +
               ", Category=" + category + ", Stock=" + stock + ", Description=" + description + "]";
    }
}
