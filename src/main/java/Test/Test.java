package Test;

import java.util.stream.IntStream;

public class Test {

    public static void main(String[] args) {

        IntStream.of(1,15,20,3,9)
                .filter(x -> x > 10)
                .distinct()
                .count();
    }
}
