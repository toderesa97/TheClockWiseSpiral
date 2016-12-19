import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by tdrs on 16/12/16.
 */
public class TheClockwiseSpiralTest {
    TheClockwiseSpiral spiral = new TheClockwiseSpiral();

    @Test
    public void should_retrieve_the_correct_spiral_when_N_2 (){
        int[][] expected = new int[][]{{1,2},{4,3}};
        assertArrayEquals(new int[][]{}, spiral.createSpiral(-1));
        assertArrayEquals(expected, spiral.createSpiral(2));
    }

    @Test
    public void should_test_spiral() {
        int[][] expected = new int[][]{
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}};

        assertArrayEquals(expected, spiral.createSpiral(3));

    }
}
