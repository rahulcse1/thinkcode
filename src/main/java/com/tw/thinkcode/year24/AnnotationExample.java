package com.tw.thinkcode.year24;


@interface MyAnnotation {
    String value() default "Hello World!";
    int count() default 1;
}

public class AnnotationExample {
    @MyAnnotation(value = "Hello, this is a test", count = 2)
    static void testAnnotation() {
        System.out.println("This is a test method");
    }
    public static void main(String[] args) {
        testAnnotation();
    }
}
