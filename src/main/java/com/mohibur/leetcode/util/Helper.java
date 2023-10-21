package com.mohibur.leetcode.util;

import lombok.Data;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Helper {

    // Helper method to get property names that have null values in the source object
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        return Stream.of(src.getPropertyDescriptors())
                .map(PropertyDescriptor::getName)
                .filter(name -> src.getPropertyValue(name) == null)
                .toArray(String[]::new);
    }

    // set null numeric values to zero
    public static void setNullNumericPropertiesToZero(Object object) throws IllegalAccessException, NoSuchFieldException {
        // Get the BeanWrapper for the object
        BeanWrapper beanWrapper = new BeanWrapperImpl(object);

        // Iterate over all properties of the object
        for (PropertyDescriptor propertyDescriptor : beanWrapper.getPropertyDescriptors()) {
            // Get the name and type of the property
            String propertyName = propertyDescriptor.getName();
            Class<?> propertyType = propertyDescriptor.getPropertyType();

            // If the property is numeric and null, set it to zero
            if (Number.class.isAssignableFrom(propertyType)) {
                Object propertyValue = beanWrapper.getPropertyValue(propertyName);
                if (propertyValue == null) {
                    Field field = object.getClass().getDeclaredField(propertyName);
                    field.setAccessible(true);
                    if (Integer.class.isAssignableFrom(propertyType)) {
                        field.set(object, 0);
                    } else if (Float.class.isAssignableFrom(propertyType)) {
                        field.set(object, 0.0F);
                    } else if (Double.class.isAssignableFrom(propertyType)) {
                        field.set(object, 0.0);
                    } else if (Long.class.isAssignableFrom(propertyType)) {
                        field.set(object, 0L);
                    }
                }
            }
        }
    }

    // set null string values to empty string
    public static void setNullStringPropertiesToEmpty(Object object) {
        // Get the BeanWrapper for the object
        BeanWrapper beanWrapper = new BeanWrapperImpl(object);

        // Iterate over all properties of the object
        for (PropertyDescriptor propertyDescriptor : beanWrapper.getPropertyDescriptors()) {
            // Get the name and type of the property
            String propertyName = propertyDescriptor.getName();
            Class<?> propertyType = propertyDescriptor.getPropertyType();

            // If the property is String and null, set it to an empty String
            if (String.class.isAssignableFrom(propertyType)) {
                Object propertyValue = beanWrapper.getPropertyValue(propertyName);
                if (propertyValue == null) {
                    beanWrapper.setPropertyValue(propertyName, "");
                }
            }
        }
    }

    /**
     * get all properties of object except the properties
     * that are mentioned in the notIncludedProps arrayList.
     *
     * @Parameter: An object named object whose properties have to get and
     * an arrayList which properties should not be included in the answer.
     * @Return: An array of String of properties not including the properties mentioned in the notIncludedProps.
     */
    public static String[] getProps(Object object, ArrayList<String> notIncludedProps) {
        Field[] fields = object.getClass().getDeclaredFields();
        ArrayList<String> props = new ArrayList<>();
        for (Field field : fields) {
            if (!notIncludedProps.contains(field.getName())) {
                props.add(field.getName());
            }
        }
        return props.toArray(new String[0]);
    }

    // main method to test above methods
    public static void main(String[] args) {
        try {
            MyObject object = new MyObject();
            System.out.println("Before : " + object);
            String[] nullProps = getNullPropertyNames(object);
            System.out.println("null props : " + Arrays.toString(nullProps));

            setNullNumericPropertiesToZero(object);
            System.out.println("After number replacement : " + object);
            nullProps = getNullPropertyNames(object);
            System.out.println("null props : " + Arrays.toString(nullProps));

            setNullStringPropertiesToEmpty(object);
            System.out.println("After string replacement : " + object);
            nullProps = getNullPropertyNames(object);
            System.out.println("null props : " + Arrays.toString(nullProps));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Data
    static class MyObject {
        private String stringV;
        private Integer integerV;
        private Float floatV;
        private Double doubleV;
        private Long longV;
    }
}
