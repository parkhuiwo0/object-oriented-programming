package domain;

public class SequenceCondition implements DiscountCondition {

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }

    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }


}
