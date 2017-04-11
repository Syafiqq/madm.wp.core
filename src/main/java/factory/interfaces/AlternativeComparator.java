package factory.interfaces;

import org.jetbrains.annotations.NotNull;

/*
 * This <wp> created by : 
 * Name         : syafiq
 * Date / Time  : 11 April 2017, 4:04 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public interface AlternativeComparator<T>
{
    boolean betterThan(@NotNull T alternative);
}
