package case_1;

import case_1.alternative.Warehouse;
import case_1.container.PriorityContainer;
import case_1.criterion.FactoryDistance;
import case_1.criterion.MarketDistance;
import case_1.criterion.SocialDensity;
import case_1.criterion.SoilCost;
import case_1.criterion.WarehouseDistance;
import case_1.properties.Identity;
import case_1.weight.ContinuousWeight;

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
