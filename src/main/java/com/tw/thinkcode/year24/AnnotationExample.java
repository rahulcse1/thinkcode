package com.tw.thinkcode.year24;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import lombok.Data;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface JsonSerializable {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonElement {
    public String key() default "";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Init {
}

@JsonSerializable
@Data
class Person {

    @JsonElement
    private String firstName;

    @JsonElement
    private String lastName;

    @JsonElement(key = "personAge")
    private String age;

    private String address;

    @Init
    private void initNames() {
        this.firstName = this.firstName.substring(0, 1).toUpperCase() 
          + this.firstName.substring(1);
        this.lastName = this.lastName.substring(0, 1).toUpperCase() 
          + this.lastName.substring(1);
    }
}


public class AnnotationExample {
   public static void main(String[] args) {

   }
}
