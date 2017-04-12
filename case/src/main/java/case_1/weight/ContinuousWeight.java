package case_1.weight;

import case_1.accumulator.DoubleAccumulator;
import factory.Weight;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

/*
 * This <wp> created by : 
 * Name         : syafiq
 * Date / Time  : 11 April 2017, 5:28 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class ContinuousWeight extends Weight<DoubleAccumulator>
{
    private double weight;
    private double normalized;

    public ContinuousWeight(double weight)
    {
        this.weight = weight;
    }

    public double getNormalized()
    {
        return this.normalized;
    }

    public void setNormalized(double normalized)
    {
        this.normalized = normalized;
    }

    public double getWeight()
    {
        return this.weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    @Override public void normalize(@NotNull DoubleAccumulator accumulator)
    {
        this.normalized = this.weight / accumulator.getValue();
    }

    @Override public String toString()
    {
        return new ToStringBuilder(this)
                .append("weight", weight)
                .append("normalized", normalized)
                .toString();
    }
}
