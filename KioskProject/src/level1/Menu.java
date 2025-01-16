package level1;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> items;

    public Menu() {
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void displayMenu() {
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
        System.out.println("0. 종료       ");
    }

    public MenuItem getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        } else {
            return null;
        }
    }

    public int getSize() {
        return items.size();
    }
}

