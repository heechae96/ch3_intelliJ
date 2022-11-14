package com.fastcampus.ch3_intelliJ.diCopy4;

import com.google.common.reflect.ClassPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// @Component 애너테이션을 제거하면 자동주입이 불가능하여 null이 출력
@Component
class Car {
    //    @Autowired
    @Resource
    Engine engine;
    //    @Autowired
    @Resource
    Door door;

    @Override
    public String toString() {
        return "Car{" + "engine=" + engine + ", door=" + door + '}';
    }
}

@Component
class Door {
}

@Component
class SportsCar extends Car {
}

@Component
class Truck extends Car {
}

@Component
class Engine {
}

class AppContext {
    Map map;    // 객체 저장소

    AppContext() {
        map = new HashMap();
        doComponentScan();
        doAutowired();  // byType
        doResource();   // byName
    }

    private void doResource() {
        // map에 저장된 객체의 iv중에 @Resource가 붙어있으면
        // map에서 iv의 이름에 맞는 객체를 찾아서 연결(객체의 주소를 iv저장)
        try {
            for (Object bean : map.values()) {
                for (Field fld : bean.getClass().getDeclaredFields()) {
                    if (fld.getAnnotation(Resource.class) != null) // byName
                        fld.set(bean, getBean(fld.getName()));  // car.engine = obj;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doAutowired() {
        // map에 저장된 객체의 iv중에 @Autowired가 붙어있으면
        // map에서 iv의 타입에 맞는 객체를 찾아서 연결(객체의 주소를 iv저장)
        try {
            for (Object bean : map.values()) {
                for (Field fld : bean.getClass().getDeclaredFields()) {
                    if (fld.getAnnotation(Autowired.class) != null) // byType
                        fld.set(bean, getBean(fld.getType()));  // car.engine = obj;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doComponentScan() {
        try {
            // Guava(구아바)라이브러리 필요 -> maven repo -> pom.xml에 추가
            // 1. 패키지내의 클래스 목록을 가져온다
            // 2. 반복문으로 클래스를 하나씩 읽어서 @Component가 붙어있는지 확인
            // 3. @Component가 붙어있으면, 객체를 생성해서 map에 저장
            ClassLoader classLoader = AppContext.class.getClassLoader();
            ClassPath classPath = ClassPath.from(classLoader);

            Set<ClassPath.ClassInfo> set = classPath.getTopLevelClasses("com.fastcampus.ch3_intelliJ.diCopy4");

            for (ClassPath.ClassInfo classInfo : set) {
                Class clazz = classInfo.load();
                Component component = (Component) clazz.getAnnotation(Component.class);

                if (component != null) {
                    String id = StringUtils.uncapitalize(classInfo.getSimpleName());
                    map.put(id, clazz.newInstance());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 이름(id)로 찾기   [key]
    // byName
    Object getBean(String key) {
        return map.get(key);
    }

    // 타입으로 찾기      [value]
    //byType
    Object getBean(Class clazz) {
        for (Object obj : map.values()) {
            if (clazz.isInstance(obj)) {
                return obj;
            }
        }
        return null;
    }
}

public class Main4 {
    public static void main(String[] args) throws Exception {
        AppContext ac = new AppContext();
        Car car = (Car) ac.getBean("car");  //byName
        Engine engine = (Engine) ac.getBean("engine");  //byName
        System.out.println("car = " + car);
        System.out.println("engine = " + engine);

        System.out.println("----------------------------------------------");

        Car car2 = (Car) ac.getBean(Car.class); // byType
        Engine engine2 = (Engine) ac.getBean(Engine.class);  // byType
        System.out.println("car2 = " + car2);
        System.out.println("engine2 = " + engine2);

        Door door = (Door) ac.getBean(Door.class);  // byType
        System.out.println("door = " + door);

        System.out.println("----------------------------------------------");

        // 수동으로 객체를 연결
//        car.engine = engine;
//        car.door = door;

        // @Autowired로 자동 연결(doAutowired()메소드로 작동하게 함)
        // @Resorce로 자동 연결(doResource()메소드로 작동하게 함
        System.out.println("engine = " + engine);
        System.out.println("door = " + door);
        System.out.println("수동주입 후 : car = " + car);
    }
}
