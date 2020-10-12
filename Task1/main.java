package Task1;

import Task1.model.Product;
import Task1.model.SpecialProduct;

public class main {

    public static void main(String[] args) {
        Product p1=new Product("Laptop",100000);
        Product p2=new Product("Laptop",100000);
        Product p3=new Product("mobile",20000);

        System.out.println(p1.equals(p2));
        SpecialProduct s=SpecialProduct.applyOffOnProduct(p1,10);
        System.out.println(s);
    }
}

