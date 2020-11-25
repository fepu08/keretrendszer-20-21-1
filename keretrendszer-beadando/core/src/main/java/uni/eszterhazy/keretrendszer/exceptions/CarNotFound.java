package uni.eszterhazy.keretrendszer.exceptions;

public class CarNotFound extends Throwable {
    public CarNotFound(String id) {
        super(id);
    }
}
