package level7;

import java.util.*;
import java.util.stream.Collectors;

// 키오스크 클래스: 프로그램의 메인 로직 처리
public class Kiosk {
    private final Scanner scanner = new Scanner(System.in); // 사용자 입력 처리 객체
    private final List<MenuItem> menuItems = new ArrayList<>(); // 전체 메뉴 저장 리스트
    private final List<MenuItem> cart = new ArrayList<>(); // 장바구니 저장 리스트

    // 생성자: 초기 메뉴 설정
    public Kiosk() {
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        menuItems.add(new MenuItem("Coke", 2.0, "탄산음료"));
        menuItems.add(new MenuItem("Lemonade", 2.5, "상큼한 레모네이드"));
        menuItems.add(new MenuItem("IceCream", 3.0, "바닐라 아이스크림"));
        menuItems.add(new MenuItem("Brownie", 3.5, "초코 브라우니"));
    }

    // 프로그램 실행 메서드
    public void start() {
        while (true) {
            showMainMenu(); // 메인 메뉴 출력
            int choice = getUserChoice(); // 사용자 입력

            switch (choice) {
                case 1 -> handleMenu("Burgers", 0, 3); // 버거 메뉴 처리
                case 2 -> handleMenu("Drinks", 4, 5); // 음료 메뉴 처리
                case 3 -> handleMenu("Desserts", 6, 7); // 디저트 메뉴 처리
                case 4 -> handleOrders(); // 주문 처리
                case 0 -> {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                default -> System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }

    // 메인 메뉴 출력
    private void showMainMenu() {
        System.out.println("[ MAIN MENU ]");
        System.out.println("1. Burgers");
        System.out.println("2. Drinks");
        System.out.println("3. Desserts");
        if (!cart.isEmpty()) {
            System.out.println("4. Orders");
        }
        System.out.println("0. 종료");
        System.out.print("번호를 선택하세요: ");
    }

    // 특정 메뉴 처리
    private void handleMenu(String menuName, int startIndex, int endIndex) {
        System.out.println("[ " + menuName + " MENU ]");
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println((i - startIndex + 1) + ". " + menuItems.get(i));
        }
        System.out.println("0. 뒤로가기");
        System.out.print("번호를 선택하세요: ");

        int choice = getUserChoice();
        if (choice > 0 && choice <= (endIndex - startIndex + 1)) {
            MenuItem selectedItem = menuItems.get(startIndex + choice - 1);
            System.out.println(selectedItem);
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인        2. 취소");

            int confirm = getUserChoice();
            if (confirm == 1) {
                cart.add(selectedItem);
                System.out.println(selectedItem.getName() + " 이 장바구니에 추가되었습니다.");
            }
        } else if (choice != 0) {
            System.out.println("잘못된 입력입니다.");
        }
    }

    // 주문 처리
    private void handleOrders() {
        if (cart.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다. 메인 메뉴로 돌아갑니다.");
            return;
        }

        System.out.println("[ Orders ]");
        cart.forEach(item -> System.out.println(item));
        double total = cart.stream().mapToDouble(MenuItem::getPrice).sum();
        System.out.println("[ Total ]");
        System.out.println("W " + total);

        System.out.println("1. 주문      2. 메뉴판");
        int choice = getUserChoice();

        if (choice == 1) {
            processDiscount(total);
        } else {
            System.out.println("메인 메뉴로 돌아갑니다.");
        }
    }

    // 할인 및 주문 완료 처리
    private void processDiscount(double total) {
        System.out.println("할인 정보를 입력해주세요.");
        System.out.println("1. 국가유공자 : 10% ");
        System.out.println("2. 군인     :  5% ");
        System.out.println("3. 학생     :  3% ");
        System.out.println("4. 일반     :  0% ");

        int userTypeChoice = getUserChoice();
        UserType userType = switch (userTypeChoice) {
            case 1 -> UserType.NATIONAL_HERO;
            case 2 -> UserType.SOLDIER;
            case 3 -> UserType.STUDENT;
            default -> UserType.GENERAL;
        };

        double discount = total * userType.getDiscountRate();
        total -= discount;

        System.out.println("주문이 완료되었습니다. 금액은 W " + total + " 입니다.");
        printReceipt(total, discount, userType);
        cart.clear();
    }

    // 영수증 출력
    private void printReceipt(double total, double discount, UserType userType) {
        System.out.println("\n[ 영수증 ]");
        System.out.println("=============================");
        System.out.println("구매 내역:");
        cart.forEach(item -> System.out.println("- " + item));
        System.out.println("-----------------------------");
        System.out.println("할인율: " + (userType.getDiscountRate() * 100) + "%");
        System.out.println("할인 금액: W " + discount);
        System.out.println("총 금액: W " + total);
        System.out.println("=============================");
    }

    // 사용자 입력
    private int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}

