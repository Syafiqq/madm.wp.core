package factory;

import java.util.LinkedList;
import java.util.List;

/*
 * This <wp> created by : 
 * Name         : syafiq
 * Date / Time  : 11 April 2017, 4:03 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class WP
{
    private List<Alternative> alternatives;
    private Accumulator       weightAccumulator;
    private Accumulator       preferenceAccumulator;
    private WeightContainer   weight;

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
            for(final Alternative alternative : this.alternatives)
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
        if(alternatives.size() > 0)
        {
            for(final Alternative alternative : this.alternatives)
            {
                alternative.collectPreferences(this.preferenceAccumulator);
            }
            for(final Alternative alternative : this.alternatives)
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

    public void process()
    {
        this.compile();
        this.calculate();
        this.ranking();
    }

    public boolean addAlternative(Alternative t)
    {
        return alternatives.add(t);
    }

    public Alternative getBestAlternative()
    {
        Alternative best = null;
        if(alternatives.size() > 0)
        {
            best = this.alternatives.get(0);
            for(final Alternative alternative : this.alternatives)
            {
                if(alternative.betterThan(best))
                {
                    best = alternative;
                }
            }
        }
        else
        {
            System.err.println("At least one alternative exists");
            System.exit(0);
        }
        return best;
    }

    public Accumulator getWeightAccumulator()
    {
        return this.weightAccumulator;
    }

    public void setWeightAccumulator(Accumulator weightAccumulator)
    {
        this.weightAccumulator = weightAccumulator;
    }

    public Accumulator getPreferenceAccumulator()
    {
        return this.preferenceAccumulator;
    }

    public void setPreferenceAccumulator(Accumulator preferenceAccumulator)
    {
        this.preferenceAccumulator = preferenceAccumulator;
    }

    public WeightContainer getWeight()
    {
        return this.weight;
    }

    public void setWeight(WeightContainer weight)
    {
        this.weight = weight;
    }
}
