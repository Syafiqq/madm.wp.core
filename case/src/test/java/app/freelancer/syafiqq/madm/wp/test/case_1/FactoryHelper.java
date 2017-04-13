package app.freelancer.syafiqq.madm.wp.test.case_1;

import app.freelancer.syafiqq.madm.wp.test.case_1.alternative.Warehouse;
import app.freelancer.syafiqq.madm.wp.test.case_1.container.PriorityContainer;
import app.freelancer.syafiqq.madm.wp.test.case_1.criterion.FactoryDistance;
import app.freelancer.syafiqq.madm.wp.test.case_1.criterion.MarketDistance;
import app.freelancer.syafiqq.madm.wp.test.case_1.criterion.SocialDensity;
import app.freelancer.syafiqq.madm.wp.test.case_1.criterion.SoilCost;
import app.freelancer.syafiqq.madm.wp.test.case_1.criterion.WarehouseDistance;
import app.freelancer.syafiqq.madm.wp.test.case_1.properties.Identity;
import app.freelancer.syafiqq.madm.wp.test.case_1.weight.ContinuousWeight;

/*
 * This <wp> created by : 
 * Name         : syafiq
 * Date / Time  : 12 April 2017, 6:41 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class FactoryHelper
{
    public static Warehouse createWarehouse(String name, double marketDistance, double socialDensity, double factoryDistance, double warehouseDistance, double soilCost)
    {
        return new Warehouse(
                new Identity(name),
                new MarketDistance(marketDistance),
                new SocialDensity(socialDensity),
                new FactoryDistance(factoryDistance),
                new WarehouseDistance(warehouseDistance),
                new SoilCost(soilCost)
        );
    }

    public static PriorityContainer createPriorityContainer(double marketDistance, double socialDensity, double factoryDistance, double warehouseDistance, double soilCost)
    {
        return new PriorityContainer(
                new ContinuousWeight(marketDistance),
                new ContinuousWeight(socialDensity),
                new ContinuousWeight(factoryDistance),
                new ContinuousWeight(warehouseDistance),
                new ContinuousWeight(soilCost)
        );

    }
}
