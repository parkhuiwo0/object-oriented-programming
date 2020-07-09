package domain;

import java.time.LocalDateTime;

public class Screening {

    private Movie move;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie move, int sequence, LocalDateTime whenScreened) {
        this.move = move;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }
}
