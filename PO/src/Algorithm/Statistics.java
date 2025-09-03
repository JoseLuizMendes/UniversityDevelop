package Algorithm;

public class Statistics {
    public long comparisons;
    public long moves;
    public long execTime; // in nanoseconds

    public Statistics(long comparisons, long moves, long execTime) {
        this.comparisons = comparisons;
        this.moves = moves;
        this.execTime = execTime;
    }

    @Override
    public String toString() {
        double seconds = execTime / 1_000_000_000.0;
        return "Comparisons: " + comparisons + 
               " | Moves: " + moves + 
               " | Time: " + seconds + " s";
    }
}
