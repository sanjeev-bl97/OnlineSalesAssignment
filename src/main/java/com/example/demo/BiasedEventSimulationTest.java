import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class BiasedEventSimulationTest {

       @Test
    public void testEmptyOutcomes() {
        List<BiasedEventSimulation.Outcome> outcomes = new ArrayList<>();

        int numOccurrences = 1000;
        int[] occurrenceCounts = new int[outcomes.size()];

        for (int i = 0; i < numOccurrences; i++) {
            int outcome = BiasedEventSimulation.simulateEvent(outcomes);
            occurrenceCounts[outcome - 1]++;
        }

        for (int count : occurrenceCounts) {
            Assert.assertEquals(0, count);
        }
    }

    @Test
    public void testSingleOutcomeWithZeroProbability() {
        List<BiasedEventSimulation.Outcome> outcomes = new ArrayList<>();
        outcomes.add(new BiasedEventSimulation.Outcome(1, 0));

        int numOccurrences = 1000;
        int[] occurrenceCounts = new int[outcomes.size()];

        for (int i = 0; i < numOccurrences; i++) {
            int outcome = BiasedEventSimulation.simulateEvent(outcomes);
            occurrenceCounts[outcome - 1]++;
        }

        Assert.assertEquals(0, occurrenceCounts[0]);
    }

    @Test
    public void testEqualProbabilities() {
        List<BiasedEventSimulation.Outcome> outcomes = new ArrayList<>();
        outcomes.add(new BiasedEventSimulation.Outcome(1, 20));
        outcomes.add(new BiasedEventSimulation.Outcome(2, 20));
        outcomes.add(new BiasedEventSimulation.Outcome(3, 20));
        outcomes.add(new BiasedEventSimulation.Outcome(4, 20));
        outcomes.add(new BiasedEventSimulation.Outcome(5, 20));

        int numOccurrences = 1000;
        int[] occurrenceCounts = new int[outcomes.size()];

        for (int i = 0; i < numOccurrences; i++) {
            int outcome = BiasedEventSimulation.simulateEvent(outcomes);
            occurrenceCounts[outcome - 1]++;
        }

        for (int count : occurrenceCounts) {
            Assert.assertEquals(numOccurrences / outcomes.size(), count, 100);
        }
    }

    @Test
    public void testSingleOutcomeWithMaxProbability() {
        List<BiasedEventSimulation.Outcome> outcomes = new ArrayList<>();
        outcomes.add(new BiasedEventSimulation.Outcome(1, 100));

        int numOccurrences = 1000;
        int[] occurrenceCounts = new int[outcomes.size()];

        for (int i = 0; i < numOccurrences; i++) {
            int outcome = BiasedEventSimulation.simulateEvent(outcomes);
            occurrenceCounts[outcome - 1]++;
        }

        Assert.assertEquals(numOccurrences, occurrenceCounts[0]);
    }


    @Test
    public void testUnequalProbabilitiesWithZeroProbability() {
        List<BiasedEventSimulation.Outcome> outcomes = new ArrayList<>();
        outcomes.add(new BiasedEventSimulation.Outcome(1, 30));
        outcomes.add(new BiasedEventSimulation.Outcome(2, 10));
        outcomes.add(new BiasedEventSimulation.Outcome(3, 15));
        outcomes.add(new BiasedEventSimulation.Outcome(4, 0));
        outcomes.add(new BiasedEventSimulation.Outcome(5, 45));

        int numOccurrences = 1000000;
        int[] occurrenceCounts = new int[outcomes.size()];

        for (int i = 0; i < numOccurrences; i++) {
            int outcome = BiasedEventSimulation.simulateEvent(outcomes);
            occurrenceCounts[outcome - 1]++;
        }

        Assert.assertEquals(0, occurrenceCounts[3]);
    }

    
   

}
