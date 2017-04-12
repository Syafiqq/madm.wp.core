package factory;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * This <wp> created by : 
 * Name         : syafiq
 * Date / Time  : 11 April 2017, 4:03 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class WP
{
    private @NotNull  List<Alternative> alternatives;
    private @Nullable Accumulator       weightAccumulator;
    private @Nullable Accumulator       preferenceAccumulator;
    private @Nullable WeightContainer   weight;

    public WP()
    {
        this.alternatives = new LinkedList<>();
    }

    public void compile()
    {
        if(alternatives.size() > 0)
        {
            if((this.weight == null) || (this.weightAccumulator == null))
            {
                System.err.println("Weight Properties Must Be Initialized");
                System.exit(0);
            }
            else
            {
                this.weight.normalize(this.weightAccumulator);
            }
        }
        else
        {
            System.err.println("At least one alternative exists");
            System.exit(0);
        }

    }

    public void calculate()
    {
        if(alternatives.size() > 0)
        {
            for(@NotNull final Alternative alternative : this.alternatives)
            {
                alternative.calculatePreferences(this.weight);
            }
        }
        else
        {
            System.err.println("At least one alternative exists");
            System.exit(0);
        }
    }

    public void ranking()
    {
        if(this.alternatives.size() > 0)
        {
            for(@NotNull final Alternative alternative : this.alternatives)
            {
                alternative.collectPreferences(this.preferenceAccumulator);
            }
            for(@NotNull final Alternative alternative : this.alternatives)
            {
                alternative.ranking(this.preferenceAccumulator);
            }
        }
        else
        {
            System.err.println("At least one alternative exists");
            System.exit(0);
        }
    }

    public void sort()
    {
        this.alternatives.sort(Comparator.naturalOrder());
    }

    public void process()
    {
        this.compile();
        this.calculate();
        this.ranking();
        this.sort();
    }

    public Alternative getBestAlternative()
    {
        @Nullable Alternative best = null;
        if(alternatives.size() > 0)
        {
            @NotNull final Alternative first = this.alternatives.get(0);
            @NotNull final Alternative last  = this.alternatives.get(this.alternatives.size() - 1);
            best = first.compareTo(last) >= 0 ? last : first;
        }
        else
        {
            System.err.println("At least one alternative exists");
            System.exit(0);
        }
        return best;
    }

    public boolean addAlternative(@NotNull Alternative t)
    {
        return alternatives.add(t);
    }

    @NotNull public List<Alternative> getAlternatives()
    {
        return this.alternatives;
    }

    @Nullable public Accumulator getWeightAccumulator()
    {
        return this.weightAccumulator;
    }

    public void setWeightAccumulator(@NotNull Accumulator weightAccumulator)
    {
        this.weightAccumulator = weightAccumulator;
    }

    @Nullable public Accumulator getPreferenceAccumulator()
    {
        return this.preferenceAccumulator;
    }

    public void setPreferenceAccumulator(@NotNull Accumulator preferenceAccumulator)
    {
        this.preferenceAccumulator = preferenceAccumulator;
    }

    @Nullable public WeightContainer getWeight()
    {
        return this.weight;
    }

    public void setWeight(@NotNull WeightContainer weight)
    {
        this.weight = weight;
    }
}
