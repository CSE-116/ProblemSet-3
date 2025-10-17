package problem.datastructures.comparators;

public class IntInverseDistanceFromReference implements Comparator<Integer> {

    private int reference;

    public IntInverseDistanceFromReference(int reference){
        this.reference = reference;
    }

    private int distance(int a){
        return Math.abs(a - this.reference);
    }

    private double inverseDistance(int a){
        return 1.0 / this.distance(a);
    }

    @Override
    public boolean compare(Integer a, Integer b) {
        return this.inverseDistance(a) < this.inverseDistance(b);
    }
}
