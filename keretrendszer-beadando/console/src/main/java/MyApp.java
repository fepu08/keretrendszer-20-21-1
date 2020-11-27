import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import uni.eszterhazy.keretrendszer.dao.CarDAO;
import uni.eszterhazy.keretrendszer.service.CarService;

public class MyApp {
    public static void main(String args[]){
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        CarDAO dao = (CarDAO)context.getBean("mongoDbDAO");
        //System.out.println(dao.readAllCar());
        CarService service = (CarService) context.getBean("carService");
        System.out.println(service.getAllCar());
    }
}
