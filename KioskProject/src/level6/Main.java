package level6;

public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();

        // Burgers 메뉴 추가
        Menu burgerMenu = new Menu("Burgers");
        burgerMenu.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        kiosk.addMenu(burgerMenu);

        // Drinks 메뉴 추가
        Menu drinksMenu = new Menu("Drinks");
        drinksMenu.addMenuItem(new MenuItem("Coca-Cola", 1.9, "차갑고 시원한 코카콜라"));
        drinksMenu.addMenuItem(new MenuItem("Sprite", 1.9, "상쾌한 레몬 라임 스프라이트"));
        drinksMenu.addMenuItem(new MenuItem("Lemonade", 2.5, "신선한 레몬 주스와 설탕의 조화"));
        kiosk.addMenu(drinksMenu);

        // Desserts 메뉴 추가
        Menu dessertsMenu = new Menu("Desserts");
        dessertsMenu.addMenuItem(new MenuItem("Ice Cream", 3.9, "달콤하고 부드러운 아이스크림"));
        dessertsMenu.addMenuItem(new MenuItem("Brownie", 4.5, "진한 초콜릿 맛 브라우니"));
        dessertsMenu.addMenuItem(new MenuItem("Cheesecake", 5.0, "부드러운 크림치즈로 만든 치즈케이크"));
        kiosk.addMenu(dessertsMenu);

        // 프로그램 실행
        kiosk.start();
    }
}
