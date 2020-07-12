package domain;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public abstract class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    public Movie(String title, Duration runningTime, Money fee, DiscountCondition ...discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = Arrays.asList(discountConditions);
    }

    public Money getFee() {
        return fee;
    }

    /*
    두 가지의 할인 종류 정책이 존재하는데, 코드 상에서는 어떤 할인 정책을 사용할 것인지에 대해 결정하지 않는다.
    단지 discountPolicy에 메시지를 전송할 뿐이다.

    상속(inheritance), 다형성, 그리고 추상화(abstraction)
     */
    public Money calculateMovieFee(Screening screening) {
        if (isDiscoiuntable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    abstract protected Money calculateDiscountAmount();

    /*
    실행 시점에 할인 정책을 변경할 수 있도록 하기 위해서, (유연한 설계의 목표)
     */
    public void changeDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

}
