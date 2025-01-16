package level3;

import java.util.Scanner;

public class Kiosk {
    private Menu menu;

    public Kiosk(Menu menu) {
        this.menu = menu;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            menu.showMenuItems();
            System.out.print("메뉴를 선택하세요: ");
            String input = scanner.nextLine();

            try {
                int choice = Integer.parseInt(input);

                if (choice == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    running = false;
                } else if (choice > 0 && choice <= menu.getMenuSize()) {
                    MenuItem selectedItem = menu.getMenuItem(choice - 1);
                    if (selectedItem != null) {
                        System.out.println(selectedItem.getName() + "를 선택하셨습니다. 가격: $" + selectedItem.getPrice());
                    } else {
                        System.out.println("유효하지 않은 메뉴입니다.");
                    }
                } else {
                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력하세요.");
            }
        }

        scanner.close();
    }
}

