package level4;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String categoryName;
    private List<MenuItem> menuItems;

    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void displayMenuItems() {
        System.out.println("[ " + categoryName.toUpperCase() + " MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i));
        }
        System.out.println("0. 뒤로가기");
    }
}

