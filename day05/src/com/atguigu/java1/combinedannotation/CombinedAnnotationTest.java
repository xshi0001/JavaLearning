package com.atguigu.java1.combinedannotation;

import org.junit.Test;

import javax.annotation.*;
import java.lang.annotation.*;

/**
 * TODO
 *
 * @author JClearLove
 * @date 2021/04/21 09:39
 */

public class CombinedAnnotationTest {
    @Test
    public void testCombinedAnnotation() {
        Class classz = UserService.class;


    }


    private static void getAnnos(Class<?> classz) {
        Annotation[] annotations = classz.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation.annotationType() != Deprecated.class &&
                    annotation.annotationType() != SuppressWarnings.class &&
                    annotation.annotationType() != Override.class &&
                    annotation.annotationType() != PostConstruct.class &&
                    annotation.annotationType() != PreDestroy.class &&
                    annotation.annotationType() != Resource.class &&
                    annotation.annotationType() != Resources.class &&
                    annotation.annotationType() != Generated.class &&
                    annotation.annotationType() != Target.class &&
                    annotation.annotationType() != Retention.class &&
                    annotation.annotationType() != Documented.class &&
                    annotation.annotationType() != Inherited.class
            ) {
                if (annotation.annotationType() == MyComponent.class) {
                    System.out.println(" 存在注解 @MyComponent ");
                } else {
                    getAnnos(annotation.annotationType());
                }
            }
        }

    }

}

