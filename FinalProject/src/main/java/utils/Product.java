package utils;

import java.util.Objects;

public class Product {
    private String name;
    private String description;
    private Double price;
    private Boolean inStock;

    public Product(String name, String description, Double price, Boolean inStock){
        this.name = name;
        this.description = description;
        this.price = price;
        this.inStock = inStock;
    }

    // Getters
    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public Double getPrice(){
        return this.price;
    }

    public Boolean getInStock(){
        return this.inStock;
    }
    ///////////////////

    // Setters
    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public void setInStock(Boolean inStock){
        this.inStock = inStock;
    }
    ////////////////////


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getName().equals(product.getName()) &&
                getDescription().equals(product.getDescription()) &&
                getPrice().equals(product.getPrice()) &&
                getInStock().equals(product.getInStock());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getPrice(), getInStock());
    }
}
