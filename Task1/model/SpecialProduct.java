package Task1.model;

public class SpecialProduct extends Product {
    int regularPrice;
    int percentageOff;

    public SpecialProduct(String name,int price) {
        super(name,price);

    }


    @Override
    public String toString() {
        return String.format("Name : %s @ Rs. %d",name,price);
    }

    public static Task1.model.SpecialProduct applyOffOnProduct(Product product, int percentageOff)
    {
        int discountedPrice=product.price-((product.price*percentageOff)/100);
        Task1.model.SpecialProduct specialProduct=new Task1.model.SpecialProduct(product.name,discountedPrice);
        specialProduct.regularPrice=product.price;
        specialProduct.percentageOff=percentageOff;

        return specialProduct;
    }
}
