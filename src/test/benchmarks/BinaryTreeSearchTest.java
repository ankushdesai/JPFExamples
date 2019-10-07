import benchmarks.BinarySearchTree;
import gov.nasa.jpf.util.test.TestJPF;
import gov.nasa.jpf.vm.Verify;
import org.junit.Test;

public class BinaryTreeSearchTest extends TestJPF {

    @Test
    public void insert1000() {
        if (verifyNoPropertyViolation("src/test/benchmarks/benchmarksTest.jpf")) {
            final int N = 100;

            BinarySearchTree b = new BinarySearchTree();
            for (int i = 0; i < N; i++) {
                b.insert(i);// Concolic.input.Integer());
            }
        }
    }

    @Test
    public void search1000() {
        if (verifyNoPropertyViolation("src/test/benchmarks/benchmarksTest.jpf")) {
            final int N = 100;
            BinarySearchTree b = new BinarySearchTree();
            for (int i = 0; i < N; i++) {
                b.insert(i);// Concolic.input.Integer());
            }
        }
    }
}
