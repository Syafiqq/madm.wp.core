package case_0.container;

import case_0.accumulator.DoubleAccumulator;
import case_0.weight.ContinuousWeight;
import factory.WeightContainer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

/*
 * This <wp> created by : 
 * Name         : syafiq
 * Date / Time  : 11 April 2017, 4:27 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class PriorityContainer extends WeightContainer<DoubleAccumulator>
{
    @NotNull private ContinuousWeight cost;
    @NotNull private ContinuousWeight webAccess;
    @NotNull private ContinuousWeight processor;
    @NotNull private ContinuousWeight weight;
    @NotNull private ContinuousWeight screenDimension;
    @NotNull private ContinuousWeight ram;
    @NotNull private ContinuousWeight cameraQuality;
    @NotNull private ContinuousWeight rom;

    public PriorityContainer(@NotNull ContinuousWeight cost, @NotNull ContinuousWeight webAccess, @NotNull ContinuousWeight processor, @NotNull ContinuousWeight weight, @NotNull ContinuousWeight screenDimension, @NotNull ContinuousWeight ram, @NotNull ContinuousWeight cameraQuality, @NotNull ContinuousWeight memory)
    {
        this.cost = cost;
        this.webAccess = webAccess;
        this.processor = processor;
        this.weight = weight;
        this.screenDimension = screenDimension;
        this.ram = ram;
        this.cameraQuality = cameraQuality;
        this.rom = memory;
    }

    @Override public void normalize(@NotNull DoubleAccumulator accumulator)
    {
        double total = 0;
        total += this.cost.getWeight();
        total += this.webAccess.getWeight();
        total += this.processor.getWeight();
        total += this.weight.getWeight();
        total += this.screenDimension.getWeight();
        total += this.ram.getWeight();
        total += this.cameraQuality.getWeight();
        total += this.rom.getWeight();

        accumulator.setValue(total);

        this.cost.normalize(accumulator);
        this.webAccess.normalize(accumulator);
        this.processor.normalize(accumulator);
        this.weight.normalize(accumulator);
        this.screenDimension.normalize(accumulator);
        this.ram.normalize(accumulator);
        this.cameraQuality.normalize(accumulator);
        this.rom.normalize(accumulator);
    }

    @NotNull public ContinuousWeight getCost()
    {
        return this.cost;
    }

    @NotNull public ContinuousWeight getWebAccess()
    {
        return this.webAccess;
    }

    @NotNull public ContinuousWeight getProcessor()
    {
        return this.processor;
    }

    @NotNull public ContinuousWeight getWeight()
    {
        return this.weight;
    }

    @NotNull public ContinuousWeight getScreenDimension()
    {
        return this.screenDimension;
    }

    @NotNull public ContinuousWeight getRam()
    {
        return this.ram;
    }

    @NotNull public ContinuousWeight getCameraQuality()
    {
        return this.cameraQuality;
    }

    @NotNull public ContinuousWeight getRom()
    {
        return this.rom;
    }

    @Override public String toString()
    {
        return new ToStringBuilder(this)
                .append("cost", cost)
                .append("webAccess", webAccess)
                .append("processor", processor)
                .append("weight", weight)
                .append("screenDimension", screenDimension)
                .append("ram", ram)
                .append("cameraQuality", cameraQuality)
                .append("rom", rom)
                .toString();
    }
}
