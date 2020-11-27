import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uni.eszterhazy.keretrendszer.controller.CarController;
import uni.eszterhazy.keretrendszer.dao.CarDAO;
import uni.eszterhazy.keretrendszer.service.CarService;

public class MyApp {
    public static void main(String args[]){
        //ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        //CarDAO dao = (CarDAO)context.getBean("mongoDbDAO");
        //System.out.println(dao.readAllCar());
        //CarService service = (CarService) context.getBean("carService");
        //System.out.println(service.getAllCar());
        //CarController controller = (CarController)context.getBean("carCont");
        //controller.printAll();

        ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
        //CarDAO dao = (CarDAO)context.getBean("mongoDbDAO");
        CarService service = (CarService)context.getBean("carService");
        System.out.println(service.getAllCar());
    }
}
