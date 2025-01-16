package level2;

import java.util.Scanner;

public class Kiosk {
    private Menu menu;
    private Scanner scanner;

    public Kiosk() {
        menu = new Menu();
        scanner = new Scanner(System.in);
        setupMenu();
    }

    private void setupMenu() {
        menu.addItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menu.addItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menu.addItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menu.addItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    public void start() {
        while (true) {
            menu.displayMenu();
            System.out.print("번호를 선택하세요: ");

            try {
                int choice = scanner.nextInt();

                if (choice == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (choice >= 1 && choice <= menu.getSize()) {
                    MenuItem selected = menu.getItem(choice - 1);
                    System.out.println(selected.getName() + "를 선택하셨습니다.");
                } else {
                    System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                }
            } catch (Exception e) {
                System.out.println("숫자를 입력해주세요.");
                scanner.nextLine(); // 잘못된 입력 처리
            }
            System.out.println();
        }

        scanner.close();
    }
}

