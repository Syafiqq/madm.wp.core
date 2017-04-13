package app.freelancer.syafiqq.madm.wp.test.case_0;

import app.freelancer.syafiqq.madm.wp.core.factory.WeightContainer;
import app.freelancer.syafiqq.madm.wp.test.case_0.accumulator.DoubleAccumulator;
import app.freelancer.syafiqq.madm.wp.test.case_0.alternative.SmartPhone;
import app.freelancer.syafiqq.madm.wp.test.case_0.container.PriorityContainer;
import app.freelancer.syafiqq.madm.wp.test.case_0.criterion.CameraQuality;
import app.freelancer.syafiqq.madm.wp.test.case_0.criterion.Cost;
import app.freelancer.syafiqq.madm.wp.test.case_0.criterion.Processor;
import app.freelancer.syafiqq.madm.wp.test.case_0.criterion.RandomAccessMemory;
import app.freelancer.syafiqq.madm.wp.test.case_0.criterion.ReadOnlyMemory;
import app.freelancer.syafiqq.madm.wp.test.case_0.criterion.ScreenDimension;
import app.freelancer.syafiqq.madm.wp.test.case_0.criterion.WebAccess;
import app.freelancer.syafiqq.madm.wp.test.case_0.criterion.Weight;
import app.freelancer.syafiqq.madm.wp.test.case_0.properties.SimpleProperty;
import app.freelancer.syafiqq.madm.wp.test.case_0.weight.ContinuousWeight;

/*
 * This <wp> created by : 
 * Name         : syafiq
 * Date / Time  : 11 April 2017, 10:28 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class FactoryHelper
{
    public static SmartPhone createSmartPhone(String name, int cost, int webAccess, int processor, int weight, double screenDimension, int ram, int cameraQuality, int rom)
    {
        return new SmartPhone(
                new SimpleProperty(name),
                new Cost(cost),
                new WebAccess(webAccess),
                new Processor(processor),
                new Weight(weight),
                new ScreenDimension(screenDimension),
                new RandomAccessMemory(ram),
                new CameraQuality(cameraQuality),
                new ReadOnlyMemory(rom)
        );
    }

    public static WeightContainer<DoubleAccumulator> createPriorityContainer(double cost, double webAccess, double processor, double weight, double screenDimension, double ram, double cameraQuality, double rom)
    {
        return new PriorityContainer(
                new ContinuousWeight(cost),
                new ContinuousWeight(webAccess),
                new ContinuousWeight(processor),
                new ContinuousWeight(weight),
                new ContinuousWeight(screenDimension),
                new ContinuousWeight(ram),
                new ContinuousWeight(cameraQuality),
                new ContinuousWeight(rom)
        );

    }
}
