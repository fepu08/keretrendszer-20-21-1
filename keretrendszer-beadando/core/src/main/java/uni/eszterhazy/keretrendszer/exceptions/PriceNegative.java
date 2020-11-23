package uni.eszterhazy.keretrendszer.exceptions;

public class PriceNegative extends Throwable {
    public PriceNegative(double price) {
        super(String.valueOf(price));
    }
}
