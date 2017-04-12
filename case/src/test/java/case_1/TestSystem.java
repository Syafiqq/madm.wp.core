package case_1;

import case_1.accumulator.DoubleAccumulator;
import factory.Accumulator;
import factory.Alternative;
import factory.WP;
import factory.WeightContainer;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

/*
 * This <wp> created by : 
 * Name         : syafiq
 * Date / Time  : 12 April 2017, 6:46 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class TestSystem
{
    @Test
    public void testSystem()
    {
        @NotNull Alternative a1 = FactoryHelper.createWarehouse("a1", 0.75, 2000, 18, 50, 500);
        @NotNull Alternative a2 = FactoryHelper.createWarehouse("a2", 0.50, 1500, 20, 40, 450);
        @NotNull Alternative a3 = FactoryHelper.createWarehouse("a3", 0.90, 2050, 35, 35, 800);

        @NotNull WeightContainer w  = FactoryHelper.createPriorityContainer(5, 3, 4, 4, 2);
        @NotNull Accumulator     wa = new DoubleAccumulator(0.0);
        @NotNull Accumulator     pa = new DoubleAccumulator(0.0);

        WP wp = new WP();
        wp.addAlternative(a1);
        wp.addAlternative(a2);
        wp.addAlternative(a3);

        wp.setWeightAccumulator(wa);
        wp.setPreferenceAccumulator(pa);
        wp.setWeight(w);

        wp.compile();
        wp.calculate();
        wp.ranking();
        wp.sort();

        System.out.println(wp.getBestAlternative());
        System.out.println(wp.getAlternatives());
    }
}
