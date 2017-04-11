package case_0.criterion;

import case_0.type.CriterionType;
import case_0.weight.ContinuousWeight;
import factory.Criterion;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.math3.util.FastMath;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/*
 * This <wp> created by : 
 * Name         : syafiq
 * Date / Time  : 11 April 2017, 4:47 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class ReadOnlyMemory extends Criterion<ContinuousWeight>
{
    @NotNull private static CriterionType TYPE              = CriterionType.BENEFIT;
    private static          double        WEIGHT            = 0;
    private static          double        NORMALIZED_WEIGHT = 0;


    private int    value;
    private double normalization;

    public ReadOnlyMemory(int value)
    {
        this.value = value;
    }

    @Contract(pure = true) @NotNull public static CriterionType getType()
    {
        return ReadOnlyMemory.TYPE;
    }

    public static void setType(@NotNull CriterionType TYPE)
    {
        ReadOnlyMemory.TYPE = TYPE;
    }

    @Contract(pure = true) public static double getWEIGHT()
    {
        return ReadOnlyMemory.WEIGHT;
    }

    public static void setWeight(double WEIGHT)
    {
        ReadOnlyMemory.WEIGHT = WEIGHT;
    }

    @Contract(pure = true) public static double getNormalizedWeight()
    {
        return ReadOnlyMemory.NORMALIZED_WEIGHT;
    }

    public static void setNormalizedWeight(double normalizedWeight)
    {
        ReadOnlyMemory.NORMALIZED_WEIGHT = normalizedWeight;
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
        switch(ReadOnlyMemory.TYPE)
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
