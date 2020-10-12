package Task2.model;

public class GroceryCartItem extends GroceryItem {
    int price;
    float quantity;

    public GroceryCartItem(String name, int pricePerKg) {
        super(name, pricePerKg);
    }

    @Override
    public String toString() {
        return String.format("%s (₹%d X %.2fkg)= ₹%d",name,pricePerKg,quantity,price);
    }

    public static float extractQuantity(String quantityStr)
    {
        float temp=0;
        String[] s=quantityStr.split(" ",2);
        for (String splitedString:s) {
            if(splitedString.contains("kg")) { ;
                String s1=splitedString.replace("kg", "");
                temp = temp + Integer.parseInt(s1);
            }
            else {
                String s1=splitedString.replace("g", "");
                temp+=Float.parseFloat(s1)/1000;
            }
        }
        return temp;
    }

    public static GroceryCartItem createNew(GroceryItem item,String quantityStr)
    {
        GroceryCartItem cartItem=new GroceryCartItem(item.name,item.pricePerKg);
        cartItem.quantity=extractQuantity(quantityStr);
        cartItem.price= (int) (cartItem.quantity*item.pricePerKg);
        return cartItem;
    }

    public static void main(String[] args) {
        String a="5kg";
        System.out.println(extractQuantity("5kg 250g"));
    }

}
