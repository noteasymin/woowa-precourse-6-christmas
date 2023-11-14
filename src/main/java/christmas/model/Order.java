package christmas.model;

public class Order {
    private String menuName;
    private int quantity;
    private String category;

    public Order(String menuName, int quantity, String category) {
        this.menuName = menuName;
        this.quantity = quantity;
        this.category = category;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }
}
