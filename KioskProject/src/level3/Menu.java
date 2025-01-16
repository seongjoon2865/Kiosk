package level3;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String name; // 메뉴의 이름
    private List<MenuItem> menuItems;

    public Menu(String name) {
        this.name = name;
        this.menuItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public MenuItem getMenuItem(int index) {
        if (index >= 0 && index < menuItems.size()) {
            return menuItems.get(index);
        }
        return null;
    }

    public void showMenuItems() {
        System.out.println("\n=== " + name + " ===");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i));
        }
        System.out.println("0. 종료");
    }

    public int getMenuSize() {
        return menuItems.size();
    }
}
