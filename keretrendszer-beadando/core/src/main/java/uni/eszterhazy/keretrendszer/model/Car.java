package uni.eszterhazy.keretrendszer.model;

import org.apache.log4j.Logger;
import uni.eszterhazy.keretrendszer.exceptions.BadProductionDate;
import uni.eszterhazy.keretrendszer.exceptions.ColorCannotBeEmpty;
import uni.eszterhazy.keretrendszer.exceptions.ModelCannotBeEmpty;
import uni.eszterhazy.keretrendszer.exceptions.PriceNegative;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Car {
    private String id;
    private String model;
    private String color;
    private LocalDate productionDate;
    private double price;
    private FuelType fuelType;
    private List<Extra> extras;

    Logger logger = Logger.getLogger(this.getClass());

    public Car() {
        this.id = UUID.randomUUID().toString();
        logger.info("New car created with ID: " + this.id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) throws ModelCannotBeEmpty {
        if(model.length() == 0){
            throw new ModelCannotBeEmpty();
        }
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) throws ColorCannotBeEmpty {
        if(color.length() == 0){
            throw new ColorCannotBeEmpty();
        }
        this.color = color;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) throws BadProductionDate {
        if(productionDate.isAfter(LocalDate.now())){
            throw new BadProductionDate("Future date");
        } else if (productionDate.isBefore(LocalDate.now().minusYears(20))) {
            // We dont want to sell cars older than 20 years
            throw new BadProductionDate("Car age cannot be more than 20 years");
        }
        this.productionDate = productionDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws PriceNegative {
        if(price < 0){
            throw new PriceNegative(price);
        }
        this.price = price;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public List<Extra> getExtras() {
        return extras;
    }

    public void setExtras(List<Extra> extras) {
        this.extras = extras;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", makeYear=" + productionDate +
                ", price=" + price +
                ", fuelType=" + fuelType +
                ", extras=" + extras +
                '}';
    }
}
