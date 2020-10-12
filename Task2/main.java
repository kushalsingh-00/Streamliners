package Task2;

import Task2.model.Cart;
import Task2.model.GroceryCartItem;
import Task2.model.GroceryItem;

public class main {
    public static void main(String[] args) {
        GroceryItem g1=new GroceryItem("Wheat",15);
        GroceryItem g2=new GroceryItem("Poha",40);
        GroceryItem g3=new GroceryItem("Sugar",35);
        GroceryItem g4=new GroceryItem("Rice",60);

        Cart cart=new Cart();
        cart.add(GroceryCartItem.createNew(g1,"10kg 0g"))
                .add(GroceryCartItem.createNew(g2,"2kg 500g"))
                .add(GroceryCartItem.createNew(g3,"5kg 250g"))
                .add(GroceryCartItem.createNew(g4,"2kg 500g"));

        System.out.println(cart);
    }
}
