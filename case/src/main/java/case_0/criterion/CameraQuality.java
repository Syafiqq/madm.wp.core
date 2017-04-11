package case_0.criterion;

import case_0.type.CriterionType;
import case_0.weight.ContinuousWeight;
import factory.Criterion;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.math3.util.FastMath;
import org.jetbrains.annotations.NotNull;

/*
 * This <wp> created by : 
 * Name         : syafiq
 * Date / Time  : 11 April 2017, 4:46 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class CameraQuality extends Criterion<ContinuousWeight>
{
    private final static CriterionType TYPE = CriterionType.BENEFIT;

    private int    value;
    private double normalization;

    public CameraQuality(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return this.value;
    }

    public void setValue(int value)
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
        switch(CameraQuality.TYPE)
        {
            case BENEFIT:
            {
                this.normalization = FastMath.pow(this.value, weight.getNormalized());
            }
            case COST:
            {
                this.normalization = FastMath.pow(this.value, -weight.getNormalized());
            }
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
