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
        cart.add(GroceryCartItem.createNew(g1,"10kg"))
                .add(GroceryCartItem.createNew(g1,"2kg"))
//                .add(GroceryCartItem.createNew(g3,"15"))
                .add(GroceryCartItem.createNew(g4,"2kg 500g"));

//        float a=GroceryCartItem.extractQuantity("15kg 400g");
        System.out.println(cart);
    }
}
