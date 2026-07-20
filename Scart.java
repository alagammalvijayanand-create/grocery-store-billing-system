import java.util.*;

class ShoppingCart{
    private Map<String,Double> items = new HashMap<>();
    private boolean discountApplied = false;
    private boolean isCheckedOut = false;

    public void addItem(String name ,double price){
        if(!isCheckedOut){
            items.put(name,price);
        }else{
            System.out.println("can't modify checked out cart");
        }
    }
    
    public boolean applyDiscount(String code){
        if(code=="SAVE20" && !discountApplied && !isCheckedOut){
            discountApplied = true;
            return true;
        }
        return false;
    }

    public double getTotal(){
        double sum = 0.0;
        for(Map.Entry<String,Double> elem : items.entrySet()){
            sum += elem.getValue();
        }
        if(discountApplied) sum -= sum/(double)10;
        return sum;
    }

    public void checkout(){
        if(items.size()>0 && !isCheckedOut){
            isCheckedOut = true;
        }
    }
}
public class Scart{
    public static void main(String[] args){
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("HairSerum",999.99);
        cart.addItem("Sunscreen",566.99);

        System.out.println("Total: $" + cart.getTotal());

        System.out.println("Discount: " + cart.applyDiscount("SAVE20"));
        System.out.println("Total: $" + cart.getTotal());

        System.out.println("Discount: " + cart.applyDiscount("SAVE20"));

        cart.checkout();
        cart.addItem("BodyWash", 99.99);
        System.out.println("Total: $" + cart.getTotal());
    }
}
