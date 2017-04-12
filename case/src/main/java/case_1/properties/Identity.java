package case_1.properties;

import factory.Properties;
import org.apache.commons.lang3.builder.ToStringBuilder;

/*
 * This <wp> created by : 
 * Name         : syafiq
 * Date / Time  : 11 April 2017, 11:03 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class Identity extends Properties
{
    private String name;

    public Identity(String name)
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
