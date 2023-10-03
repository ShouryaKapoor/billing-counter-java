import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class ShoppingCart {
    private List<Item> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Item item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }
}

public class BillingCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("1. Add item to cart");
            System.out.println("2. Remove item from cart");
            System.out.println("3. View cart");
            System.out.println("4. Calculate total");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String itemName = scanner.next();
                    System.out.print("Enter item price: ");
                    double itemPrice = scanner.nextDouble();
                    System.out.print("Enter item quantity: ");
                    int itemQuantity = scanner.nextInt();
                    Item newItem = new Item(itemName, itemPrice, itemQuantity);
                    cart.addItem(newItem);
                    break;

                case 2:
                    System.out.print("Enter item name to remove: ");
                    String itemToRemove = scanner.next();
                    for (Item item : cart.getItems()) {
                        if (item.getName().equals(itemToRemove)) {
                            cart.removeItem(item);
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.println("Items in your cart:");
                    for (Item item : cart.getItems()) {
                        System.out.println(item.getName() + " - $" + item.getTotalPrice() + " (" + item.getQuantity() + " items)");
                    }
                    break;

                case 4:
                    System.out.println("Total price: $" + cart.calculateTotalPrice());
                    break;

                case 5:
                    scanner.close();
                    System.out.println("Thank you for shopping!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
