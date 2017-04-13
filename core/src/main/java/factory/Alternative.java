package factory;

import org.jetbrains.annotations.NotNull;

/*
 * This <wp> created by : 
 * Name         : syafiq
 * Date / Time  : 11 April 2017, 4:01 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public abstract class Alternative<WC extends WeightContainer, PA extends Accumulator> implements Comparable<Alternative>
{
    public abstract void calculatePreferences(@NotNull WC alternative);

    public abstract void collectPreferences(@NotNull PA accumulator);

    public abstract void ranking(@NotNull PA accumulator);
}
