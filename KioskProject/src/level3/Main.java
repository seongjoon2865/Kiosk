package level3;

public class Main {
    public static void main(String[] args) {
        // 메뉴 생성
        Menu menu = new Menu("Main Menu");
        menu.addMenuItem(new MenuItem("햄버거", 5.99, "맛있는 햄버거"));
        menu.addMenuItem(new MenuItem("치즈버거", 6.99, "치즈가 듬뿍 들어간 버거"));
        menu.addMenuItem(new MenuItem("감자튀김", 2.99, "바삭한 감자튀김"));
        menu.addMenuItem(new MenuItem("콜라", 1.99, "시원한 콜라"));

        // 키오스크 실행
        Kiosk kiosk = new Kiosk(menu);
        kiosk.start();
    }
}
