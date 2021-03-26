import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest {

    @ParameterizedTest(name="#{index} - Test with Argument={0}, {1}")
    @MethodSource("getParameters")
    public void PriorityQueue_RunTest(int[] random_array, int[] correct_array) {
        PriorityQueue<Integer> pq = new java.util.PriorityQueue<Integer>();
        for (int i = 0;i < random_array.length;i++) {
            pq.add(random_array[i]);
        }
        int[] result = new int[random_array.length];
        for (int i = 0;i < random_array.length;i++) {
            result[i] = pq.poll();
        }

        assertArrayEquals(correct_array, result);

    }

    public static Stream<Arguments> getParameters() {
        return Stream.of(
                Arguments.of(new int[] {2, 4, 3}, new int[] {2, 3, 4}),
                Arguments.of(new int[] {4, 6, 2, 0}, new int[] {0, 2, 4, 6}),
                Arguments.of(new int[] {-8, 6, 0, -4}, new int[] {-8, -4, 0, 6}),
                Arguments.of(new int[] {7, 9, 5, 8, -1}, new int[] {-1, 5, 7, 8, 9}),
                Arguments.of(new int[] {3, 6, 9, -2}, new int[] {-2, 3, 6, 9})
        );
        
        /* Failure version to test CI(add 1 to value of zero index) */
        // return Stream.of(
        //         Arguments.of(new int[] {2, 4, 3}, new int[] {3, 3, 4}),
        //         Arguments.of(new int[] {4, 6, 2, 0}, new int[] {1, 2, 4, 6}),
        //         Arguments.of(new int[] {-8, 6, 0, -4}, new int[] {-7, -4, 0, 6}),
        //         Arguments.of(new int[] {7, 9, 5, 8, -1}, new int[] {0, 5, 7, 8, 9}),
        //         Arguments.of(new int[] {3, 6, 9, -2}, new int[] {-1, 3, 6, 9})
        // );
    }

    @Test
    public void initialCapacityTest_IllegalArgumentException() {
        // Parameters:
        // initialCapacity - the initial capacity for this priority queue
        // comparator - the comparator that will be used to order this priority queue. If null, the natural ordering of the elements will be used.
        // Throws:
        // IllegalArgumentException - if initialCapacity is less than 1
        // Reference docs:
        // https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new PriorityQueue(-1, null);
        });
    }

    @Test
    public void addNullTest_NullPointerException() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new PriorityQueue().add(null);
        });
    }

    @Test
    public void forEachTest_NullPointerException() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new PriorityQueue().forEach(null);
        });
    }
}