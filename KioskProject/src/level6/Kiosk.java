package level6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus = new ArrayList<>();
    private List<MenuItem> cart = new ArrayList<>();
    private double totalAmount = 0;

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            handleMainMenu(scanner);
        }
    }

    private void handleMainMenu(Scanner scanner) {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
        }
        System.out.println((menus.size() + 1) + ". Orders");
        System.out.println("0. 종료");
        System.out.print("번호를 선택하세요: ");
        int menuChoice = scanner.nextInt();

        if (menuChoice == 0) {
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        } else if (menuChoice > 0 && menuChoice <= menus.size()) {
            handleSubMenu(scanner, menus.get(menuChoice - 1));
        } else if (menuChoice == menus.size() + 1) {
            handleOrderMenu(scanner);
        } else {
            System.out.println("잘못된 메뉴 번호입니다.");
        }
    }

    private void handleSubMenu(Scanner scanner, Menu menu) {
        while (true) {
            System.out.println("[" + menu.getCategoryName() + " MENU ]");
            menu.showMenuItems();
            System.out.print("번호를 선택하세요: ");
            int itemChoice = scanner.nextInt();

            if (itemChoice == 0) {
                break;
            }

            MenuItem selectedItem = menu.getMenuItem(itemChoice - 1);
            if (selectedItem != null) {
                System.out.println(selectedItem.getName() + " | W " + selectedItem.getPrice() + " | " + selectedItem.getDescription());
                System.out.print("이 메뉴를 장바구니에 추가하시겠습니까?\n1. 확인 2. 취소\n번호를 선택하세요: ");
                int confirmChoice = scanner.nextInt();
                if (confirmChoice == 1) {
                    addItemToCart(selectedItem);
                }
            } else {
                System.out.println("유효하지 않은 메뉴 번호입니다.");
            }
        }
    }

    private void addItemToCart(MenuItem menuItem) {
        cart.add(menuItem);
        totalAmount += menuItem.getPrice();
        System.out.println(menuItem.getName() + " 이 장바구니에 추가되었습니다.");
    }

    private void handleOrderMenu(Scanner scanner) {
        if (cart.isEmpty()) {
            System.out.println("장바구니에 항목이 없습니다. 먼저 메뉴를 추가해주세요.");
            return;
        }

        System.out.println("[ Orders ]");
        for (MenuItem item : cart) {
            System.out.println(item.getName() + " | W " + item.getPrice() + " | " + item.getDescription());
        }
        System.out.println("\n[ Total ]");
        System.out.println("W " + totalAmount);
        System.out.println("1. 주문      2. 메뉴판");
        System.out.print("번호를 선택하세요: ");
        int orderChoice = scanner.nextInt();

        switch (orderChoice) {
            case 1:
                completeOrder();
                break;
            case 2:
                return;
            default:
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                break;
        }
    }

    private void completeOrder() {
        System.out.println("주문이 완료되었습니다. 금액은 W " + totalAmount + " 입니다.");
        cart.clear();
        totalAmount = 0;
    }
}
