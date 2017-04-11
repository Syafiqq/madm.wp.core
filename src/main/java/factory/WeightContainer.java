package factory;

import org.jetbrains.annotations.NotNull;

/*
 * This <wp> created by : 
 * Name         : syafiq
 * Date / Time  : 11 April 2017, 4:02 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public abstract class WeightContainer<AC extends Accumulator>
{
    public abstract void normalize(@NotNull AC accumulator);
}

