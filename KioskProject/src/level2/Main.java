package level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // List 선언 및 초기화
        List<MenuItem> menuItems = new ArrayList<>();

        // MenuItem 객체 추가
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // Scanner 선언
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 메뉴 출력
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println((i + 1) + ". " + menuItems.get(i));
            }
            System.out.println("0. 종료          | 종료");
            System.out.print("번호를 선택하세요: ");

            // 숫자 입력 받기
            try {
                int choice = scanner.nextInt();

                // 입력된 숫자에 따른 처리
                if (choice == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (choice >= 1 && choice <= menuItems.size()) {
                    MenuItem selectedItem = menuItems.get(choice - 1);
                    System.out.println("선택한 메뉴: " + selectedItem.getName());
                    System.out.println("가격: W " + selectedItem.getPrice());
                    System.out.println("설명: " + selectedItem.getDescription());
                } else {
                    System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                }
            } catch (Exception e) {
                System.out.println("숫자를 입력해주세요.");
                scanner.nextLine(); // 잘못된 입력 처리
            }

            System.out.println(); // 줄바꿈
        }

        scanner.close();
    }
}

