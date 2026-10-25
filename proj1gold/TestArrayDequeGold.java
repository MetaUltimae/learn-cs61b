/**
 *
 * @author 33465
 * @created 2026/10/24 20:22
 * @desciption
 *
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    private final StringBuilder log = new StringBuilder("\n");

    @Test
    public void testStudentArrayDeque() {
        // 1.init
        int step = 0;
        StudentArrayDeque<Integer> SADeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ADeque = new ArrayDequeSolution<>();
        // 2.iter
        while((step += 1) <= 30000) {
            // 2.1 check
            if (SADeque.isEmpty()) {
                choiceOpera(SADeque,ADeque,0);
                choiceOpera(SADeque,ADeque,1);
            }
            // 3.random operation
            choiceOpera(SADeque,ADeque,StdRandom.uniform(4));
        }
    }

    private void choiceOpera(StudentArrayDeque<Integer> sad, ArrayDequeSolution<Integer> ad, Integer choice) {
        /*
            0.addfirst 1.addlast 2.removefirst 3.removelast
         */
        switch (choice) {
            case 0 : {
                Integer value = StdRandom.uniform(100);
                sad.addFirst(value);
                ad.addFirst(value);
                this.log.append("addFirst(").append(value).append(")").append("\n");
                break;
            }
            case 1 : {
                Integer value = StdRandom.uniform(100);
                sad.addLast(value);
                ad.addLast(value);
                this.log.append("addLast(").append(value).append(")").append("\n");
                break;
            }
            case 2 : {
                this.log.append("removeFirst()").append("\n");
                assertEquals(this.log.toString(),ad.removeFirst(),sad.removeFirst());
                break;
            }
            case 3 : {
                this.log.append("removeLast()").append("\n");
                assertEquals(this.log.toString(),ad.removeLast(),sad.removeLast());
                break;
            }
        }

    }
}
   