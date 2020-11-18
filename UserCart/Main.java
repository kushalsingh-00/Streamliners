package UserCart;

import UserCart.model.Product;
import UserCart.model.Variant;


public class Main {
    public static void main(String[] args) {

        //weight based
        Product orange=new Product("Orange",50,2);
        Product grapes=new Product("Grapes",100,1);
        Product rice=new Product("Rice",70,1);

        Cart cart=new Cart();

        cart.addToCartWB(orange,5);
        cart.addToCartWB(grapes,2);
        cart.addToCartWB(rice,5);
        System.out.println("-------------Weight Based------------");
        System.out.println(cart.toString());

        //varient based

        Product sugar=new Product("Sugar");

        Variant sugar1=new Variant("Sugar 1kg",50);
        Variant sugar5=new Variant("Sugar 5kg",220);
        Variant sugar10=new Variant("Sugar 10kg",400);

        cart.addToCart(sugar,sugar1);
        cart.addToCart(sugar,sugar5);
        cart.addToCart(sugar,sugar10);

        System.out.println("-------------Varient And Weight Based------------");
        System.out.println(cart.toString());

        cart.removeFromCart(sugar,sugar1);
        cart.removeFromCartWB(orange);

        System.out.println(cart);

        cart.remmoveAllVarients(sugar);

    }
}