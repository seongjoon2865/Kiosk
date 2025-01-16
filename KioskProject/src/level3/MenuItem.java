package level3;

// MenuItem 클래스: 메뉴 항목의 정보를 저장
public class MenuItem {
    private final String name;        // 메뉴 이름
    private final double price;       // 메뉴 가격
    private final String description; // 메뉴 설명

    // 두 개의 매개변수를 받는 생성자: 기본 설명 제공
    public MenuItem(String name, double price) {
        this(name, price, "No description provided");
    }

    // 세 개의 매개변수를 받는 생성자
    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name; // 메뉴 이름 반환
    }

    public double getPrice() {
        return price; // 메뉴 가격 반환
    }

    public String getDescription() {
        return description; // 메뉴 설명 반환
    }

    @Override
    public String toString() {
        return name + " | W " + price + " | " + description; // 메뉴 정보를 문자열로 반환
    }
}
