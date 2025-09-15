import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    public void testNoCycle() {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        boolean result = solution.hasCycle(head);
        assertFalse(result);
    } 
    
    @Test
    public void testWithCycle() {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head; // サイクルを作成

        boolean result = solution.hasCycle(head);
        assertTrue(result);
    }

    @Test
    public void testEmptyList() {
        Solution solution = new Solution();
        boolean result = solution.hasCycle(null);
        assertFalse(result);
    }
}
