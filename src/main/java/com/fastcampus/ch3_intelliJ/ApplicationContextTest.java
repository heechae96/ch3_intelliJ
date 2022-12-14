//package com.fastcampus.ch3_intelliJ;
//
//import java.util.Arrays;
//import java.util.Map;
//import java.util.Properties;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.annotation.Scope;
//import org.springframework.context.support.GenericXmlApplicationContext;
//import org.springframework.stereotype.Component;
//
//@Component
//@Scope("prototype")
//class Door {
//}
//
//@Component
//class Engine {
//}
//
//@Component
//class TurboEngine extends Engine {
//}
//
//@Component
//class SuperEngine extends Engine {
//}
//
//@Component
//class Car {
//	@Value("red")
//	String color;
//	@Value("100")
//	int oil;
////	@Autowired
//	Engine engine;
////	@Autowired
//	Door[] doors;
//
//	public Car() {
//	}
//
//	@Autowired
//	public Car(@Value("red") String color, @Value("100") int oil, Engine engine, Door[] doors) {
//		this.color = color;
//		this.oil = oil;
//		this.engine = engine;
//		this.doors = doors;
//	}
//
//	@Override
//	public String toString() {
//		return "Car{" + "color='" + color + '\'' + ", oil=" + oil + ", engine=" + engine + ", doors="
//				+ Arrays.toString(doors) + '}';
//	}
//}
//
//@Component
//@PropertySource("setting.properties")
//class SysInfo {
//	@Value("#{systemProperties['user.timezone']}")
//	String timeZone;
//	@Value("#{systemEnvironment['TMPDIR']}")
//	String tempDir;
//	@Value("${autoSaveDir}")
//	String autoSaveDir;
//	@Value("${autoSaveInterval}")
//	int autoSaveInterval;
//	@Value("${autoSave}")
//	boolean autoSave;
//
//	@Override
//	public String toString() {
//		return "SysInfo [timeZone=" + timeZone + ", tempDir=" + tempDir + ", autoSaveDir=" + autoSaveDir
//				+ ", autoSaveInterval=" + autoSaveInterval + ", autoSave=" + autoSave + "]";
//	}
//
//}
//
//public class ApplicationContextTest {
//	public static void main(String[] args) {
//		ApplicationContext ac = new GenericXmlApplicationContext("config.xml");
//
//		System.out.println("==================================================");
//		System.out.println("ac.getBean(SysInfo.class) = " + ac.getBean(SysInfo.class));
//		Map<String, String> map = System.getenv();
//		System.out.println("map = " + map);
//		System.out.println("==================================================");
//		Properties properties = System.getProperties();
//		System.out.println("properties = " + properties);
//
//		System.out.println("==================================================");
//
////      Car car = ac.getBean("car", Car.class); // ????????? ???????????? ????????? ????????????. ????????? ????????? ??????
//		Car car = (Car) ac.getBean("car"); // ???????????? ??? ??????
////        Car car2 = (Car) ac.getBean(Car.class);   // ???????????? ??? ??????
//		System.out.println("car = " + car);
//	}
//}