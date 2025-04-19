import java.util.*;

class ShoppingCart {
    private Map<String, Double> productPrices;
    private LinkedHashMap<String, Double> cartItems;
    private TreeMap<Double, String> sortedItemsByPrice;

    public ShoppingCart() {
        this.productPrices = new HashMap<>();
        this.cartItems = new LinkedHashMap<>();
        this.sortedItemsByPrice = new TreeMap<>();
    }

    public void addProduct(String productName, double price) {
        productPrices.put(productName, price);
    }

    public void addToCart(String productName) {
        if (productPrices.containsKey(productName)) {
            double price = productPrices.get(productName);
            cartItems.put(productName, price);
            sortedItemsByPrice.put(price, productName);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayCart() {
        System.out.println("Cart items in the order they were added:");
        for (Map.Entry<String, Double> entry : cartItems.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void displaySortedCart() {
        System.out.println("\nCart items sorted by price:");
        for (Map.Entry<Double, String> entry : sortedItemsByPrice.entrySet()) {
            System.out.println(entry.getValue() + ": " + entry.getKey());
        }
    }

    public double getTotalPrice() {
        double total = 0;
        for (double price : cartItems.values()) {
            total += price;
        }
        return total;
    }

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addProduct("Laptop", 800.00);
        shoppingCart.addProduct("Headphones", 50.00);
        shoppingCart.addProduct("Mouse", 25.00);
        shoppingCart.addProduct("Keyboard", 40.00);

        shoppingCart.addToCart("Laptop");
        shoppingCart.addToCart("Headphones");
        shoppingCart.addToCart("Mouse");

        shoppingCart.displayCart();
        shoppingCart.displaySortedCart();

        System.out.println("\nTotal price of items in the cart: " + shoppingCart.getTotalPrice());
    }
}
