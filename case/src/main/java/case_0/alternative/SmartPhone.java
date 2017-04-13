package case_0.alternative;

import case_0.accumulator.DoubleAccumulator;
import case_0.container.PriorityContainer;
import case_0.criterion.CameraQuality;
import case_0.criterion.Cost;
import case_0.criterion.Processor;
import case_0.criterion.RandomAccessMemory;
import case_0.criterion.ReadOnlyMemory;
import case_0.criterion.ScreenDimension;
import case_0.criterion.WebAccess;
import case_0.criterion.Weight;
import case_0.properties.SimpleProperty;
import factory.Alternative;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

/*
 * This <wp> created by : 
 * Name         : syafiq
 * Date / Time  : 11 April 2017, 8:03 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class SmartPhone extends Alternative<PriorityContainer, DoubleAccumulator>
{
    @NotNull private Cost               cost;
    @NotNull private WebAccess          webAccess;
    @NotNull private Processor          processor;
    @NotNull private Weight             weight;
    @NotNull private ScreenDimension    screenDimension;
    @NotNull private RandomAccessMemory ram;
    @NotNull private CameraQuality      cameraQuality;
    @NotNull private ReadOnlyMemory     rom;
    @NotNull private SimpleProperty     properties;
    private          double             vectorS;
    private          double             vectorV;

    public SmartPhone(@NotNull SimpleProperty properties, @NotNull Cost cost, @NotNull WebAccess webAccess, @NotNull Processor processor, @NotNull Weight weight, @NotNull ScreenDimension screenDimension, @NotNull RandomAccessMemory ram, @NotNull CameraQuality cameraQuality, @NotNull ReadOnlyMemory rom)
    {
        this.properties = properties;
        this.cost = cost;
        this.webAccess = webAccess;
        this.processor = processor;
        this.weight = weight;
        this.screenDimension = screenDimension;
        this.ram = ram;
        this.cameraQuality = cameraQuality;
        this.rom = rom;
    }

    public Cost getCost()
    {
        return this.cost;
    }

    public void setCost(Cost cost)
    {
        this.cost = cost;
    }

    public WebAccess getWebAccess()
    {
        return this.webAccess;
    }

    public void setWebAccess(WebAccess webAccess)
    {
        this.webAccess = webAccess;
    }

    public Processor getProcessor()
    {
        return this.processor;
    }

    public void setProcessor(Processor processor)
    {
        this.processor = processor;
    }

    public Weight getWeight()
    {
        return this.weight;
    }

    public void setWeight(Weight weight)
    {
        this.weight = weight;
    }

    public ScreenDimension getScreenDimension()
    {
        return this.screenDimension;
    }

    public void setScreenDimension(ScreenDimension screenDimension)
    {
        this.screenDimension = screenDimension;
    }

    public RandomAccessMemory getRam()
    {
        return this.ram;
    }

    public void setRam(RandomAccessMemory ram)
    {
        this.ram = ram;
    }

    public CameraQuality getCameraQuality()
    {
        return this.cameraQuality;
    }

    public void setCameraQuality(CameraQuality cameraQuality)
    {
        this.cameraQuality = cameraQuality;
    }

    public ReadOnlyMemory getRom()
    {
        return this.rom;
    }

    public void setRom(ReadOnlyMemory rom)
    {
        this.rom = rom;
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

    public SimpleProperty getProperties()
    {
        return this.properties;
    }

    public void setProperties(SimpleProperty properties)
    {
        this.properties = properties;
    }

    @Override public void calculatePreferences(@NotNull PriorityContainer alternative)
    {
        this.cost.calculate(alternative.getCost());
        this.webAccess.calculate(alternative.getWebAccess());
        this.processor.calculate(alternative.getProcessor());
        this.weight.calculate(alternative.getWeight());
        this.screenDimension.calculate(alternative.getScreenDimension());
        this.ram.calculate(alternative.getRam());
        this.cameraQuality.calculate(alternative.getCameraQuality());
        this.rom.calculate(alternative.getRom());

        this.setVectorS(this.cost.getNormalization()
                * this.webAccess.getNormalization()
                * this.processor.getNormalization()
                * this.weight.getNormalization()
                * this.screenDimension.getNormalization()
                * this.ram.getNormalization()
                * this.cameraQuality.getNormalization()
                * this.rom.getNormalization()
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

    @Override public String toString()
    {
        return new ToStringBuilder(this)
                .append("cost", cost)
                .append("webAccess", webAccess)
                .append("processor", processor)
                .append("weight", weight)
                .append("screenDimension", screenDimension)
                .append("ram", ram)
                .append("cameraQuality", cameraQuality)
                .append("rom", rom)
                .append("properties", properties)
                .append("vectorS", vectorS)
                .append("vectorV", vectorV)
                .toString();
    }

    @Override public int compareTo(@NotNull Alternative o)
    {
        return -Double.compare(this.getVectorV(), ((SmartPhone) o).getVectorV());
    }
}
