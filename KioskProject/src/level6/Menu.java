package level6;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String categoryName;
    private List<MenuItem> menuItems;

    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public void showMenuItems() {
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " | W " + item.getPrice() + " | " + item.getDescription());
        }
        System.out.println("0. 뒤로가기");
    }

    public MenuItem getMenuItem(int index) {
        if (index >= 0 && index < menuItems.size()) {
            return menuItems.get(index);
        }
        return null;
    }
}

