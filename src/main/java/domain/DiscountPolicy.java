package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Template Method Pattern.
 * 부모 클래스에서 기본적인 알고리즘의 흐름을 구현하고, 중간에 필요한 처리를 자식 클래스에 위임하는 것.
 */
public abstract class DiscountPolicy {

    private List<DiscountCondition> conditions = new ArrayList<>();

    public DiscountPolicy(DiscountCondition ...conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        for(DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening screening);
}
