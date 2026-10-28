package synthesizer;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {

    Random random = new Random();
    @Test
    public void testFundamental() {
        // 1.capacity
        // 2.fillCount
        // 3.isEmpty
        // 4.enquene
        // 5.dequeue
        // 6.peek
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<Integer>(10);
        assertEquals(10, arb.capacity());
    }

    @Test
    public void testBound() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(20);
        // random test operations for 20000.
        int i = 0;
        StringBuilder log = new StringBuilder("\n");
        while((i += 1) <= 20000) {
            int choice = random.nextInt(2);
            try {
                runOperation(choice, arb, log);
            } catch (Exception e) {
                System.out.println(log);
                System.out.println(e.getMessage());
                break;
            }

        }
        System.out.println(log);
    }

    private void runOperation (int choice, ArrayRingBuffer arb, StringBuilder log) throws Exception{
        // 0 -- enqueue  1 -- dequeue
        Integer item;
        switch (choice) {
            case 0:
                if (arb.isFull()) {
                    runOperation(1, arb, log);
                    break;
                }
                item = random.nextInt(50);
                arb.enqueue(item);
                log.append("enqueue(").append(item).append(")").append("\n");
                break;
            case 1:
                if (arb.isEmpty()) {
                    runOperation(0, arb, log);
                    break;
                }
                item = (Integer) arb.dequeue();
                log.append("dequeue(): ").append(item).append("\n");
                break;
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
