package app.freelancer.syafiqq.madm.wp.test.case_1.alternative;

import app.freelancer.syafiqq.madm.wp.core.factory.Alternative;
import app.freelancer.syafiqq.madm.wp.test.case_1.accumulator.DoubleAccumulator;
import app.freelancer.syafiqq.madm.wp.test.case_1.container.PriorityContainer;
import app.freelancer.syafiqq.madm.wp.test.case_1.criterion.FactoryDistance;
import app.freelancer.syafiqq.madm.wp.test.case_1.criterion.MarketDistance;
import app.freelancer.syafiqq.madm.wp.test.case_1.criterion.SocialDensity;
import app.freelancer.syafiqq.madm.wp.test.case_1.criterion.SoilCost;
import app.freelancer.syafiqq.madm.wp.test.case_1.criterion.WarehouseDistance;
import app.freelancer.syafiqq.madm.wp.test.case_1.properties.Identity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

/*
 * This <wp> created by : 
 * Name         : syafiq
 * Date / Time  : 11 April 2017, 11:13 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class Warehouse extends Alternative<PriorityContainer, DoubleAccumulator>
{
    @NotNull private MarketDistance    marketDistance;
    @NotNull private SocialDensity     socialDensity;
    @NotNull private FactoryDistance   factoryDistance;
    @NotNull private WarehouseDistance warehouseDistance;
    @NotNull private SoilCost          soilCost;
    @NotNull private Identity          properties;
    private          double            vectorS;
    private          double            vectorV;

    public Warehouse(@NotNull Identity properties, @NotNull MarketDistance marketDistance, @NotNull SocialDensity socialDensity, @NotNull FactoryDistance factoryDistance, @NotNull WarehouseDistance warehouseDistance, @NotNull SoilCost soilCost)
    {
        this.properties = properties;
        this.marketDistance = marketDistance;
        this.socialDensity = socialDensity;
        this.factoryDistance = factoryDistance;
        this.warehouseDistance = warehouseDistance;
        this.soilCost = soilCost;
    }

    public double getVectorS()
    {
        return this.vectorS;
    }

    public void setVectorS(double vectorS)
    {
        this.vectorS = vectorS;
    }

    public double getVectorV()
    {
        return this.vectorV;
    }

    public void setVectorV(double vectorV)
    {
        this.vectorV = vectorV;
    }

    @Override public void calculatePreferences(@NotNull PriorityContainer alternative)
    {
        this.marketDistance.calculate(alternative.getMarketDistance());
        this.socialDensity.calculate(alternative.getSocialDensity());
        this.factoryDistance.calculate(alternative.getFactoryDistance());
        this.warehouseDistance.calculate(alternative.getWarehouseDistance());
        this.soilCost.calculate(alternative.getSoilCost());

        this.setVectorS(this.marketDistance.getNormalization()
                * this.socialDensity.getNormalization()
                * this.factoryDistance.getNormalization()
                * this.warehouseDistance.getNormalization()
                * this.soilCost.getNormalization()
        );
    }

    @Override public void collectPreferences(@NotNull DoubleAccumulator accumulator)
    {
        accumulator.setValue(accumulator.getValue() + this.getVectorS());
    }

    @Override public void ranking(@NotNull DoubleAccumulator accumulator)
    {
        this.setVectorV(this.getVectorS() / accumulator.getValue());
    }

    public MarketDistance getMarketDistance()
    {
        return this.marketDistance;
    }

    public void setMarketDistance(MarketDistance marketDistance)
    {
        this.marketDistance = marketDistance;
    }

    public SocialDensity getSocialDensity()
    {
        return this.socialDensity;
    }

    public void setSocialDensity(SocialDensity socialDensity)
    {
        this.socialDensity = socialDensity;
    }

    public FactoryDistance getFactoryDistance()
    {
        return this.factoryDistance;
    }

    public void setFactoryDistance(FactoryDistance factoryDistance)
    {
        this.factoryDistance = factoryDistance;
    }

    public WarehouseDistance getWarehouseDistance()
    {
        return this.warehouseDistance;
    }

    public void setWarehouseDistance(WarehouseDistance warehouseDistance)
    {
        this.warehouseDistance = warehouseDistance;
    }

    public SoilCost getSoilCost()
    {
        return this.soilCost;
    }

    public void setSoilCost(SoilCost soilCost)
    {
        this.soilCost = soilCost;
    }

    public Identity getProperties()
    {
        return this.properties;
    }

    public void setProperties(Identity properties)
    {
        this.properties = properties;
    }

    @Override public String toString()
    {
        return new ToStringBuilder(this)
                .append("marketDistance", marketDistance)
                .append("socialDensity", socialDensity)
                .append("factoryDistance", factoryDistance)
                .append("warehouseDistance", warehouseDistance)
                .append("soilCost", soilCost)
                .append("properties", properties)
                .append("vectorS", vectorS)
                .append("vectorV", vectorV)
                .toString();
    }

    @Override public int compareTo(@NotNull Alternative o)
    {
        return -Double.compare(this.getVectorV(), ((Warehouse) o).getVectorV());
    }
}
