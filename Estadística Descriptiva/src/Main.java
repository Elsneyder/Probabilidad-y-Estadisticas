import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();

        intervals.add(new Interval(25, 33, 4));
        intervals.add(new Interval(34, 42, 4));
        intervals.add(new Interval(43, 51, 8));
        intervals.add(new Interval(52, 60, 7));
        intervals.add(new Interval(61, 69, 5));
        intervals.add(new Interval(70, 78, 3));

        DescriptiveStatistics ds = new DescriptiveStatistics(intervals);
        ds.calculateStatistics();
        ds.printDescriptiveTable();
    }
}