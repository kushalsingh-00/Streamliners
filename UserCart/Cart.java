package UserCart;

import UserCart.model.Product;
import UserCart.model.Variant;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    int subTotal;
    int noOfItems;

    // all cart items present here
    Map<String,CartItem> items=new HashMap<>();

    // varient type product total quantity
    Map<String,Integer> varientQty=new HashMap<>();


    // Varient Based

    // for adding varient based cart items
    public int addToCart(Product product, Variant variant)
    {
        // generating key for varient based
        String mapKey=product.name+" "+variant.name;

        if(items.containsKey(mapKey))
        {
            //updating quantity for that varient
            items.get(mapKey).qty++;

        }
        else
        {
            items.put(mapKey,new CartItem(mapKey, variant.price));

        }

        // updating total items and price in cart
        noOfItems++;
        subTotal+= variant.price;

        //updating varients map
        if (varientQty.containsKey(product.name))
            varientQty.put(product.name,varientQty.get(product.name)+1);
        else
            varientQty.put(product.name,1);

        return (int) items.get(mapKey).qty;
    }

    // for removal of product
    public int removeFromCart(Product product,Variant variant)
    {
        String mapKey=product.name+" "+variant.name;

        //decreasing quantity
        items.get(mapKey).qty--;

        if (items.get(mapKey).qty==0)
        {
            items.remove(mapKey);
        }

        // updating total items and price in cart
        noOfItems--;
        subTotal-= variant.price;

        //updating varients map

        if(varientQty.get(product.name)==0)
            varientQty.remove(product.name);

        return items.containsKey(mapKey) ? (int) items.get(mapKey).qty :0;
    }

    // removing all varients
    public void remmoveAllVarients(Product product)
    {
        for (Variant variant:
             product.variants) {
            String key=product.name+" "+variant.name;

            if(items.containsKey(key)) {
                subTotal -=items.get(key).price;
                noOfItems-=items.get(key).qty;
                items.remove(key);
            }
        }
        if(varientQty.containsKey(product.name))
            varientQty.remove(product.name);
    }

    //Weight Based

    // for adding product weight based
    public void addToCartWB(Product product,float qty)
    {
        //calculating total price
        int newPrice= (int) (product.pricePerKg*qty);

        //decreasing changed product price
        if(items.containsKey(product.name))
        {
            subTotal-=items.get(product.name).price;
        }
        else
            //increasing count
            noOfItems++;

        // increasing new price
        items.put(product.name,new CartItem(product.name,qty,newPrice));
        subTotal+=newPrice;
    }

    // for adding product weight based
    public void removeFromCartWB(Product product)
    {
        if(items.containsKey(product.name))
        {
            subTotal-=items.get(product.name).price;
            noOfItems--;
            items.remove(product.name);
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "subTotal=" + subTotal +
                ", noOfItems=" + noOfItems +
                ", items=" + items +
                ", varientQty=" + varientQty +
                '}';
    }
}
