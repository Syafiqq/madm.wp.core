package app.freelancer.syafiqq.madm.wp.test.case_1.accumulator;

import app.freelancer.syafiqq.madm.wp.core.factory.Accumulator;
import org.apache.commons.lang3.builder.ToStringBuilder;

/*
 * This <wp> created by : 
 * Name         : syafiq
 * Date / Time  : 11 April 2017, 5:27 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class DoubleAccumulator extends Accumulator
{
    private double value;

    public DoubleAccumulator(double value)
    {
        this.value = value;
    }

    public double getValue()
    {
        return this.value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    @Override public String toString()
    {
        return new ToStringBuilder(this)
                .append("value", value)
                .toString();
    }
}
