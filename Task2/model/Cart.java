package Task2.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<GroceryCartItem> cartItems;
    float totalAmmount;

    public Cart() {
        cartItems=new ArrayList<>();
        totalAmmount=0;
    }

    public Cart add(GroceryCartItem item)
    {
        if(cartItems.contains(item.name))
        {
            totalAmmount=totalAmmount-cartItems.get(cartItems.indexOf(item.name)).price;
            cartItems.get(cartItems.indexOf(item.name)).price=item.price;
            totalAmmount+=item.price;
        }
        else {
            cartItems.add(item);
            totalAmmount += item.price;
        }
            return this;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "groceryCartItems="+
                cartItems+
                ","+
                "totalAmmount = "+totalAmmount+
                '}';
    }
}
