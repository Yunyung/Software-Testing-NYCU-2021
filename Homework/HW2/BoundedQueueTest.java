import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains 11 JUnit tests for the BoundedQueue.java. The tests are derived from an
 * IDM (input domain modeling)
 * The five methods tested are: BoundedQueue(int), enQueue(Object), deQueue(), isEmpty(), isFull()
 *
 * (a) List all of the input variables, including the state variables.
 * (b) Define the characteristics of the input variables. Make sure you cover all input variables.
 *
 * Summary (a) and (b) as two table:
 * |  Method       |  Params   |  Returns     |  Exception                 | Ch ID  | Characteristic         | Covered by
 * ----------------------------------------------------------------------------------------------------------------
 * |  BoundedQueue |  int      |              |                            |  C1    | Capacity >= 0          |
 *                                            |  IllegalArgumentException  |        |                        | C1
 * |  enQueue      |  Object   |              |                            |  C2    | Object not null        |
 *                                            |  NullPointerException      |        |                        | C2
 *                                            |  IllegalStateException     |        |                        | C5
 * |  deQueue      |  state    |  Object      |                            |  C3    | Return oldest element  |
 *                                            |  IllegalStateException     |        |                        | C4
 * |  isEmpty      |  state    |  True, False |                            |  C4    | Queue not empty        |
 * |  isFull       |  state    |  True, False |                            |  C5    | Queue not full         |
 *
 *
 *  | Ch ID  | Characteristic        | BoundedQueue  | enQueue | deQueue | isEmpty | isFull |
 *  ----------------------------------------------------------------------------------------------------------------
 *  |  C1    | Capacity >= 0         |      O        |    O    |    O    |    O    |    O    |
 *  |  C2    | Object not null       |               |    O    |         |         |         |
 *  |  C3    | Return oldest element |               |         |    O    |         |         |
 *  |  C4    | Queue not empty       |               |         |    O    |    O    |         |
 *  |  C5    | Queue not full        |               |    O    |         |         |    O    |
 *
 * (c) Partition the characteristics into blocks. Designate one block in each partition as the "Base" block.
 * (d) Define values for each block.
 *
 * -> (Each Characteristic has a boolean partition) <-
 *  |  Method       |  Characteristic  | Base  | Test Requirements       | Infeasible | # of TRs |
 *  ----------------------------------------------------------------------------------------------------------------
 *  |  BoundedQueue |  C1              | {T}   | {T, F}                  |            |    2     |
 *  |  enQueue      |  C1 C2 C5        | {TTT} | {TTT, TTF, TFT}         |    FTT     |    3     |
 *  |  deQueue      |  C1 C3 C4        | {TTT} | {TTT, TTF}              |  TFT, FTT  |    2     |
 *  |  isEmpty      |  C1 C4           | {TT}  | {TT, TF}                |     FT     |    2     |
 *  |  isFull       |  C1 C5           | {TT}  | {TT, TF}                |     FT     |    2     |
 *
 * (e) Define a test set that satisfies Base Choice Coverage (BCC). Write your
 * tests with the values from the previous step. Be sure to include the test oracles.
 *  -> Implementation as below
 *
 */

class BoundedQueueTest {

    BoundedQueue BQ = new BoundedQueue(3);
    Object firstObject = new Object();
    @BeforeEach
    public void setUp() {

        BQ.enQueue(firstObject); // Initially, add one object
    }

    /* 2 Tests for BoundedQueue(int) */
    // Test 1: C1-T
    @Test
    void TestBoundedQueueCapacity_BaseCase() {
        //Code does not throw any exception
        try {
            new BoundedQueue(3);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    // Test 2: C1-F
    @Test
    void TestBoundedQueueCapacity_C1() {
        // Should throw exception
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BoundedQueue(-1);
        });
    }

    /* 3 Tests for enQueue(Object) */
    // Test 1 of enQueue(Object): C1-T, C2-T, C5-T
    @Test
    void enQueue_BaseCase() {
        // Code does not throw any exception and error
        try {
            BQ.enQueue(new Object()); // add second object
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    // Test 2 of enQueue(Object): C1-T, C2-T, C5-F
    @Test
    void enQueue_C5() {
        BQ.enQueue(new Object());
        BQ.enQueue(new Object());
        // add new element when Queue is full
        Assertions.assertThrows(IllegalStateException.class, () -> {
            BQ.enQueue(new Object());
        });

    }

    // Test 3 of enQueue(Object): C1-T, C2-F, C5-T
    @Test
    void enQueue_C2() {
        // add null element
        Assertions.assertThrows(NullPointerException.class, () -> {
            BQ.enQueue(null);
        });
    }

    /* 3 Tests for deQueue(Object) */
    // Test 1 of deQueue(): C1-T, C3-T, C4-T
    @Test
    void deQueue_BaseCase() {
        BQ.enQueue(new Object()); // Add second object
        Object pop = BQ.deQueue(); // pop oldest(first) object
        assertTrue(pop == firstObject); // Verify return object is oldest object
    }

    // Test 2 of deQueue(): C1-T, C3-T, C4-F
    @Test
    void deQueue_C4() {
        BQ.deQueue(); // Make queue empty
        // Now BQ is empty and run deQueue()
        Assertions.assertThrows(IllegalStateException.class, () -> {
            BQ.deQueue();
        });
    }

    /* 2 Tests for isEmpty() */
    // Test 2 of isEmpty(): C1-T, C4-T
    @Test
    void isEmpty_BaseCase() {
        // Now Queue has one element, not empty
        assertFalse(BQ.isEmpty());
    }

    // Test 2 of isEmpty(): C1-T, C4-F
    @Test
    void isEmpty_C4() {
        BQ.deQueue(); // Make queue empty
        // Now BQ is empty and run isEmpty()
        assertTrue(BQ.isEmpty());
    }

    /* 2 Tests for isFull() */
    // Test 2 of isFull(): C1-T, C5-T
    @Test
    void isFull_BaseCase() {
        // Now Queue has only one element, not full
        assertFalse(BQ.isFull());
    }

    // Test 2 of isFull(): C1-T, C5-F
    @Test
    void isFull_C5() {
        BQ.enQueue(new Object());
        BQ.enQueue(new Object()); // Make queue full
        // Now BQ is full and run isFull()
        assertTrue(BQ.isFull());
    }

}