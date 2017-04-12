package case_1.criterion;

import case_1.type.CriterionType;
import case_1.weight.ContinuousWeight;
import factory.Criterion;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.math3.util.FastMath;
import org.jetbrains.annotations.NotNull;

/*
 * This <wp> created by : 
 * Name         : syafiq
 * Date / Time  : 11 April 2017, 11:08 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class FactoryDistance extends Criterion<ContinuousWeight>
{
    private final static CriterionType TYPE = CriterionType.COST;

    private double value;
    private double normalization;

    public FactoryDistance(double value)
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

    public double getNormalization()
    {
        return this.normalization;
    }

    public void setNormalization(double normalization)
    {
        this.normalization = normalization;
    }

    @Override public void calculate(@NotNull ContinuousWeight weight)
    {
        switch(FactoryDistance.TYPE)
        {
            case BENEFIT:
            {
                this.normalization = FastMath.pow(this.value, weight.getNormalized());
            }
            break;
            case COST:
            {
                this.normalization = FastMath.pow(this.value, -weight.getNormalized());
            }
            break;
        }
    }

    @Override public String toString()
    {
        return new ToStringBuilder(this)
                .append("value", value)
                .append("normalization", normalization)
                .toString();
    }
}
