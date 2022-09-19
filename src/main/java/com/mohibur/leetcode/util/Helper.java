package com.mohibur.leetcode.util;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Helper {
    /**
     * get all properties of object except the properties
     * that are mentioned in the notIncludedProps arrayList.
     *
     * @Parameter: An object named object whose properties have to get and
     * an arrayList which properties should not be included in the answer.
     *
     * @Return: An array of String of properties not including the properties mentioned in the notIncludedProps.
     */
    public String[] getProps(Object object, ArrayList<String> notIncludedProps) {
        Field[] fields = object.getClass().getDeclaredFields();
        ArrayList<String> props = new ArrayList<>();
        for (Field field : fields) {
            if (!notIncludedProps.contains(field.getName())) {
                props.add(field.getName());
            }
        }
        return props.toArray(new String[0]);
    }
}
