package level7;

// 메뉴 항목 클래스: 메뉴의 이름, 가격, 설명을 저장
public class MenuItem {
    private final String name; // 메뉴 이름
    private final double price; // 메뉴 가격
    private final String description; // 메뉴 설명

    // 생성자: 메뉴 이름, 가격, 설명을 초기화
    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // 메뉴 이름 반환
    public String getName() {
        return name;
    }

    // 메뉴 가격 반환
    public double getPrice() {
        return price;
    }

    // 메뉴 설명 반환
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        // 메뉴 정보를 문자열로 반환
        return name + " | W " + price + " | " + description;
    }
}

