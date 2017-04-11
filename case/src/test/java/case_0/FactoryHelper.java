package case_0;

import case_0.accumulator.DoubleAccumulator;
import case_0.alternative.SmartPhone;
import case_0.container.PriorityContainer;
import case_0.criterion.CameraQuality;
import case_0.criterion.Cost;
import case_0.criterion.Processor;
import case_0.criterion.RandomAccessMemory;
import case_0.criterion.ReadOnlyMemory;
import case_0.criterion.ScreenDimension;
import case_0.criterion.WebAccess;
import case_0.criterion.Weight;
import case_0.properties.SimpleProperty;
import case_0.weight.ContinuousWeight;
import factory.WeightContainer;

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
