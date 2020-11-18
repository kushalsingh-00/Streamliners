package Task2.model;

public class GroceryCartItem extends GroceryItem {
    float price;
    float quantity;

    public GroceryCartItem(String name, int pricePerKg) {
        super(name, pricePerKg);
    }

    @Override
    public String toString() {
        return String.format("%s (₹%d X %.2fkg)= ₹%f \n",name,pricePerKg,quantity,price);
    }

    /* 19kg 500g =19.500
    *  20kg =
    *  900g =*/

    public static float extractQuantity(String quantityStr)
    {
        String s=quantityStr.replace("kg ",".")
                .replace("kg",".")
                .replace("g","");

        if(!s.contains("."))
        {
            s="."+s;
        }
        return Float.parseFloat(s);
    }

    public static GroceryCartItem createNew(GroceryItem item,String quantityStr)
    {
        GroceryCartItem cartItem=new GroceryCartItem(item.name,item.pricePerKg);
        cartItem.quantity=extractQuantity(quantityStr);
        cartItem.price= cartItem.quantity*item.pricePerKg;
        return cartItem;
    }
}
