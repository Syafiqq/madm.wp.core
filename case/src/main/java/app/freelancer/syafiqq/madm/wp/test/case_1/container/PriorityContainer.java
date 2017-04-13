package app.freelancer.syafiqq.madm.wp.test.case_1.container;

import app.freelancer.syafiqq.madm.wp.core.factory.WeightContainer;
import app.freelancer.syafiqq.madm.wp.test.case_1.accumulator.DoubleAccumulator;
import app.freelancer.syafiqq.madm.wp.test.case_1.weight.ContinuousWeight;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

/*
 * This <wp> created by : 
 * Name         : syafiq
 * Date / Time  : 11 April 2017, 5:30 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class PriorityContainer extends WeightContainer<DoubleAccumulator>
{
    @NotNull private ContinuousWeight marketDistance;
    @NotNull private ContinuousWeight socialDensity;
    @NotNull private ContinuousWeight factoryDistance;
    @NotNull private ContinuousWeight warehouseDistance;
    @NotNull private ContinuousWeight soilCost;

    public PriorityContainer(@NotNull ContinuousWeight marketDistance, @NotNull ContinuousWeight socialDensity, @NotNull ContinuousWeight factoryDistance, @NotNull ContinuousWeight warehouseDistance, @NotNull ContinuousWeight soilCost)
    {
        this.marketDistance = marketDistance;
        this.socialDensity = socialDensity;
        this.factoryDistance = factoryDistance;
        this.warehouseDistance = warehouseDistance;
        this.soilCost = soilCost;
    }

    @Override public void normalize(@NotNull DoubleAccumulator accumulator)
    {
        double total = 0;
        total += this.marketDistance.getWeight();
        total += this.socialDensity.getWeight();
        total += this.factoryDistance.getWeight();
        total += this.warehouseDistance.getWeight();
        total += this.soilCost.getWeight();

        accumulator.setValue(total);

        this.marketDistance.normalize(accumulator);
        this.socialDensity.normalize(accumulator);
        this.factoryDistance.normalize(accumulator);
        this.warehouseDistance.normalize(accumulator);
        this.soilCost.normalize(accumulator);
    }

    @NotNull public ContinuousWeight getMarketDistance()
    {
        return this.marketDistance;
    }

    @NotNull public ContinuousWeight getSocialDensity()
    {
        return this.socialDensity;
    }

    @NotNull public ContinuousWeight getFactoryDistance()
    {
        return this.factoryDistance;
    }

    @NotNull public ContinuousWeight getWarehouseDistance()
    {
        return this.warehouseDistance;
    }

    @NotNull public ContinuousWeight getSoilCost()
    {
        return this.soilCost;
    }

    @Override public String toString()
    {
        return new ToStringBuilder(this)
                .append("marketDistance", marketDistance)
                .append("socialDensity", socialDensity)
                .append("factoryDistance", factoryDistance)
                .append("warehouseDistance", warehouseDistance)
                .append("soilCost", soilCost)
                .toString();
    }
}
