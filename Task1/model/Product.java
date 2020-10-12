package Task1.model;

import java.util.Objects;

public class Product {
    int price;
    String name;

    public Product() {
    }

    public Product(String name,int price) {
        this.price = price;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Name : %s @ Rs. %d",name,price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price &&
                name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }
}
