package level7;

// 사용자 유형 Enum: 각 사용자 유형에 따른 할인율을 설정
public enum UserType {
    NATIONAL_HERO(0.1), // 국가유공자: 10% 할인
    SOLDIER(0.05),      // 군인: 5% 할인
    STUDENT(0.03),      // 학생: 3% 할인
    GENERAL(0.0);       // 일반: 할인 없음

    private final double discountRate; // 할인율 저장

    UserType(double discountRate) {
        this.discountRate = discountRate; // 생성자에서 할인율 초기화
    }

    public double getDiscountRate() {
        return discountRate; // 할인율 반환
    }
}

