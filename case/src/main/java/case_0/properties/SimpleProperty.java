package case_0.properties;

import factory.Properties;
import org.apache.commons.lang3.builder.ToStringBuilder;

/*
 * This <wp> created by : 
 * Name         : syafiq
 * Date / Time  : 11 April 2017, 10:30 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class SimpleProperty extends Properties
{
    private String name;

    public SimpleProperty(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override public String toString()
    {
        return new ToStringBuilder(this)
                .append("name", name)
                .toString();
    }
}
