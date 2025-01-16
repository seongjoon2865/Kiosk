package level4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus;

    public Kiosk() {
        this.menus = new ArrayList<>();
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n[ MAIN MENU ]");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
            }
            System.out.println("0. 종료");

            System.out.print("번호를 선택하세요: ");
            int mainChoice = Integer.parseInt(scanner.nextLine());

            if (mainChoice == 0) {
                System.out.println("프로그램을 종료합니다.");
                running = false;
            } else if (mainChoice > 0 && mainChoice <= menus.size()) {
                Menu selectedMenu = menus.get(mainChoice - 1);
                processMenuSelection(scanner, selectedMenu);
            } else {
                System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            }
        }

        scanner.close();
    }

    private void processMenuSelection(Scanner scanner, Menu menu) {
        boolean back = false;
        while (!back) {
            menu.displayMenuItems();
            System.out.print("번호를 선택하세요: ");
            int subChoice = Integer.parseInt(scanner.nextLine());

            if (subChoice == 0) {
                back = true;
            } else if (subChoice > 0 && subChoice <= menu.getMenuItems().size()) {
                MenuItem selectedItem = menu.getMenuItems().get(subChoice - 1);
                System.out.println("선택한 메뉴: " + selectedItem);
            } else {
                System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            }
        }
    }
}

