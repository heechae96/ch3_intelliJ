//package com.fastcampus.ch3_intelliJ;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.Arrays;
//
//// id는 클래스 제일 앞을 소문자로 ex) Engine -> engine
////@Component("engine")  // <bean id="engine" class="com.fastcampus.ch3_intelliJ.Engine"/> 와 같은 역할
//class Engine {  // 클래스를 자바 Bean(객체)로 등록
//}
//
////@Component("superEngine")
//@Component
//class SuperEngine extends Engine {
//}
//
//@Component
//class TurboEngine extends Engine {
//}
//
//@Component
//class Door {
//}
//
//@Component
//class Car {
//    @Value("red")
//    String color;
//    @Value("100")
//    int oil;
////    @Autowired      // byType - 타입으로 먼저 검색하고, 타입 후보가 여러개면 이름으로 검색 ex) engine, turbo-, super-
////    @Qualifier("superEngine")
//    @Resource(name = "superEngine") // byName
//    Engine engine;  // type이 Engine이므로 이름 engine이 선택됨
//    @Autowired
//    Door[] doors;
//
//    public Car() {
//    }
//
//    public Car(String color, int oil, Engine engine, Door[] doors) {
//        this.color = color;
//        this.oil = oil;
//        this.engine = engine;
//        this.doors = doors;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public int getOil() {
//        return oil;
//    }
//
//    public void setOil(int oil) {
//        this.oil = oil;
//    }
//
//    public Engine getEngine() {
//        return engine;
//    }
//
//    public void setEngine(Engine engine) {
//        this.engine = engine;
//    }
//
//    public Door[] getDoors() {
//        return doors;
//    }
//
//    public void setDoors(Door[] doors) {
//        this.doors = doors;
//    }
//
//    @Override
//    public String toString() {
//        return "Car{" + "color='" + color + '\'' + ", oil=" + oil + ", engine=" + engine + ", doors=" + Arrays.toString(doors) + '}';
//    }
//}
//
//public class SpringDiTest {
//    public static void main(String[] args) {
//        // config.xml에 클래스 정보를 설정해두고, 그것은 읽어서 map형태로 저장소에 저장
//        ApplicationContext ac = new GenericXmlApplicationContext("config.xml");
//
////        Car car = (Car) ac.getBean("car");  // byName
//        Car car = ac.getBean("car", Car.class);  // name과 type을 같이 적어주면 형변환 안해도 ok
//
//        /*
//        Car car2 = (Car) ac.getBean(Car.class);  // byType
//        Engine engine = (Engine) ac.getBean("engine");
////        Engine engine2 = (Engine) ac.getBean(Engine.class); // byType   // Engine Super- Turbo- 3개라 에러
//        Engine engine2 = (Engine) ac.getBean("superEngine");
//        Door door = (Door) ac.getBean("door");
//
//        System.out.println("----------------------------------------------");
//
//        System.out.println("car2 = " + car2);
//        System.out.println("engine = " + engine);
//        System.out.println("engine2 = " + engine2);
//        System.out.println("door = " + door);
//
//        System.out.println("----------------------------------------------");
//
//        // 수동 -> @Autowired와 @Value로 객체 자동 연결
////        car.setColor("red");
////        car.setOil(100);
////        car.setEngine(engine);
////        car.setDoors(new Door[]{ac.getBean("door", Door.class), (Door) ac.getBean("door")});
//        */
//
//        System.out.println("초기화 후: car = " + car);
//    }
//}
