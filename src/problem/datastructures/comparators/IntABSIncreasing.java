package problem.datastructures.comparators;

public class IntABSIncreasing implements Comparator<Integer> {

    @Override
    public boolean compare(Integer a, Integer b) {
        return Math.abs(a) < Math.abs(b);
    }
}
