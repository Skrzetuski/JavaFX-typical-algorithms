package application.Interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public interface IEulers {

    /**
     * https://projecteuler.net/problem=1
     *
     * @return sum of all multiples of 3 or 5 below 1_000
     */
    default Integer euler1() {
        return IntStream.range(0, 1000).filter(i -> i % 3 == 0 || i % 5 == 0).sum();
    }

    /**
     * https://projecteuler.net/problem=4
     *
     * @return largest palindrome from two 3-digit numbers
     */
    default Integer euler4() {
        Integer max = 0;
        for (int i = 999; i >= 100; i--) {
            for (int j = i; j >= 100; j--) {

                StringBuilder in = new StringBuilder(String.valueOf(i * j));
                StringBuilder out = new StringBuilder(in);

                if (in.reverse().toString().equals(out.toString())) {
                    if (max < Integer.parseInt(in.toString())) {
                        max = Integer.parseInt(in.toString());
                    }
                }
            }
        }

        return max;
    }

    /**
     * The smallest positive number that is evenly divisible by all of the numbers from 1 to 20.
     * https://projecteuler.net/problem=5
     *
     * @return smallestNumber
     */
    default Long euler5() {
        Long smallestNumber = 2520L;
        boolean flag = true;
        List<Long> listOfRemainder;

        while (flag) {

            listOfRemainder = new ArrayList<>();

            for (int i = 1; i <= 20; i++) {
                listOfRemainder.add((smallestNumber % i));
            }

            if (listOfRemainder.stream().mapToInt((Long::intValue)).sum() != 0) {
                smallestNumber += 20;
                flag = true;
            } else {
                flag = false;
            }
        }
        return smallestNumber;
    }

    /**
     * Longest Collatz sequence
     * https://projecteuler.net/problem=14
     *
     * @return The number and length of chain
     */
    default String euler14() {
        Long chainStartNumber = 0L;
        Long chainLengthMax = 0L;
        Long number = 0L;
        Long length = 0L;

        for (long i = 2; i < 1_000_000; i++) {

            length = 1L;
            number = i;
            while (number != 1) {
                if (number % 2 == 0) {
                    number = number / 2;
                } else {
                    number = number * 3 + 1;
                }
                length++;
            }

            if (length > chainLengthMax) {
                chainLengthMax = length;
                chainStartNumber = i;
            }
        }
        return new StringBuilder("Number ").append(chainStartNumber)
                                           .append(" generate chain length equals to ")
                                           .append(chainLengthMax).toString();
    }
}
