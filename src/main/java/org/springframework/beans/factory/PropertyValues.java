package org.springframework.beans.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zyfgoup
 * @Date 2022/6/29 16:17
 * @Description
 **/
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv){propertyValueList.add(pv);}

    public PropertyValue[] getPropertyValues(){
        //toArray方法如果传入的数组长度小于List 则会复制一个长度=list.size()
        return this.propertyValueList.toArray(new PropertyValue[0]);}

    public PropertyValue getPropertyValue(String propertyName){
        for (PropertyValue propertyValue : propertyValueList) {
            if(propertyValue.getName().equals(propertyName)){
                return propertyValue;
            }
        }
        return null;
    }
}
