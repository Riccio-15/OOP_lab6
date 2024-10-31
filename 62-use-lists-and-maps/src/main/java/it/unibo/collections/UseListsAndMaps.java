package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int ELEM = 100_000;
    private static final int TIMES = 1_000;
    private static final int MIDDLE_POSITION = 500;
    private static final int START = 1000;
    private static final int END = 2000;
    private static final long AFRICA_POP = 1_110_635_000L;
    private static final long AMERICAS_POP = 972_005_000L;
    private static final long ANTARTICA_POP = 0L;
    private static final long ASIA_POP = 4_298_723_000L;
    private static final long EUROPE_POP = 742_452_000L;
    private static final long OCEANIA_POP = 38_304_000L;

    public enum Continents {
        Africa, Americas, Antartica, Asia, Europe, Oceania
    }

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *          unused
     */
    public static void main(final String... s) {

        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        var arr = new ArrayList<Integer>(1000);
        for (int i = START; i < END; i++) {
            arr.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        var list = new LinkedList<Integer>(arr);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int f = arr.get(0);
        arr.set(0, arr.get(arr.size() - 1));
        arr.set(arr.size() - 1, f);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer i : arr) {
            System.out.println(i + " ");
        }

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        System.out.print("inserting a new element " + ELEM + " times in a ARRAYLIST took: ");
        long time = System.nanoTime();

        for (int i = ELEM; i > 0; i--) {
            arr.set(0, i);
        }

        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
                +time
                        + "ns ("
                        + millis
                        + "ms)");

        System.out.print("inserting a new element " + ELEM + " times in a LINKEDLIST took: ");
        time = System.nanoTime();
        for (int i = ELEM; i > 0; i--) {
            list.set(0, i);
        }

        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
                +time
                        + "ns ("
                        + millis
                        + "ms)");

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */

        System.out.print("searching a MIDDLE ELEMENT " + TIMES + " times in ARRAYLIST took: ");
        time = System.nanoTime();
        for (int i = TIMES; i > 0; i--) {
            arr.get(MIDDLE_POSITION);
        }

        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
                +time
                        + "ns ("
                        + millis
                        + "ms)");

        System.out.print("searching a MIDDLE ELEMENT " + TIMES + " times in LINKEDLIST took: ");
        time = System.nanoTime();

        for (int i = TIMES; i > 0; i--) {
            list.get(MIDDLE_POSITION);
        }

        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
                +time
                        + "ns ("
                        + millis
                        + "ms)");

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        final Map<Continents, Long> world = new HashMap<>();

        world.put(Continents.Africa, AFRICA_POP);
        world.put(Continents.Americas, AMERICAS_POP);
        world.put(Continents.Antartica, ANTARTICA_POP);
        world.put(Continents.Asia, ASIA_POP);
        world.put(Continents.Europe, EUROPE_POP);
        world.put(Continents.Oceania, OCEANIA_POP);
        /*
         * 8) Compute the population of the world
         */
        long totPopulation = 0;

        for (final long p : world.values()) {
            totPopulation = totPopulation + p;
        }
        System.out.println("The world has a total population of " + totPopulation);
    }
}
