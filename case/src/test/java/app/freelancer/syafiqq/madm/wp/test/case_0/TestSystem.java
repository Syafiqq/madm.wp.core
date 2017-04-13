package app.freelancer.syafiqq.madm.wp.test.case_0;

import app.freelancer.syafiqq.madm.wp.core.factory.WP;
import app.freelancer.syafiqq.madm.wp.core.factory.WeightContainer;
import app.freelancer.syafiqq.madm.wp.test.case_0.accumulator.DoubleAccumulator;
import app.freelancer.syafiqq.madm.wp.test.case_0.alternative.SmartPhone;
import org.junit.Test;

/*
 * This <wp> created by : 
 * Name         : syafiq
 * Date / Time  : 11 April 2017, 8:27 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class TestSystem
{
    @Test public void TestSystem()
    {
        SmartPhone nokia1   = FactoryHelper.createSmartPhone("Nokia 1", 2100000, 7200, 800, 150, 3.5, 256, 3, 6);
        SmartPhone nokia2   = FactoryHelper.createSmartPhone("Nokia 2", 2000000, 7200, 600, 155, 3.7, 512, 5, 4);
        SmartPhone samsung3 = FactoryHelper.createSmartPhone("Samsung 3", 2450000, 7200, 1000, 140, 3.7, 256, 3, 6);
        SmartPhone samsung4 = FactoryHelper.createSmartPhone("Samsung 4", 2500000, 7200, 1200, 140, 4, 256, 5, 4);
        SmartPhone samsung5 = FactoryHelper.createSmartPhone("Samsung 5", 2600000, 7200, 1200, 135, 3.7, 512, 5, 4);

        DoubleAccumulator weightAccumulator     = new DoubleAccumulator(0.0);
        DoubleAccumulator preferenceAccumulator = new DoubleAccumulator(0.0);

        WeightContainer weight = FactoryHelper.createPriorityContainer(25.0, 20.0, 15.0, 10.0, 5.0, 10.0, 15.0, 25.0);

        WP wp = new WP();
        wp.setPreferenceAccumulator(preferenceAccumulator);
        wp.setWeightAccumulator(weightAccumulator);
        wp.setWeight(weight);

        wp.addAlternative(nokia1);
        wp.addAlternative(nokia2);
        wp.addAlternative(samsung3);
        wp.addAlternative(samsung4);
        wp.addAlternative(samsung5);

        wp.process();

        System.out.println(wp.getBestAlternative());

    }
}
