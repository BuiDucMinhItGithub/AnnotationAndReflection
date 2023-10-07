package com.annotation.customannotation;

import com.annotation.customannotation.annotation.CanBeNull;
import com.annotation.customannotation.annotation.RunNow;
import com.annotation.customannotation.annotation.VeryImportant;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.Annotation;

@SpringBootApplication
public class CustomAnnotationApplication {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Information information = new Information(100, "Minh");
        Method[] methods = information.getClass().getDeclaredMethods();
        Information informationReference = null;
        if (information.getClass().isAnnotationPresent(VeryImportant.class)){
            System.out.println("Very important");
            informationReference = information.getClass().cast(information);

            // Set new value
            Field name = information.getClass().getDeclaredField("name");
            name.setAccessible(true);
            String nameNew = "Umang Budhwar";
            name.set(information,nameNew);

            // Reference to other object
            System.out.println(informationReference.getName());

        }

        Field[] fields = information.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(CanBeNull.class)) {
                field.setAccessible(true);
                Object value = field.get(information);
                System.out.println(value);
            }
        }

        for (Method method1 : methods) {
            if (method1.isAnnotationPresent(RunNow.class)) {
                System.out.println("Run method now");
            }
        }
    }

}
