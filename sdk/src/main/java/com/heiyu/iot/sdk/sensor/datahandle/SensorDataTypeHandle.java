package com.heiyu.iot.sdk.sensor.datahandle;

import com.heiyu.iot.sdk.entity.Sensor.AbstractSensorDataSheet;
import com.heiyu.iot.sdk.entity.configmap.SensorConfig;
import org.springframework.stereotype.Component;

import static com.heiyu.iot.sdk.entity.configmap.ConfigMap.getConfigMap;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 9:08 2020/1/31
 **/
@Component
public class SensorDataTypeHandle {

    public static final String DATATYPE_INT = "int";
    public static final String DATATYPE_BOOLEAN = "boolean";
    public static final String DATATYPE_DOUBLE = "double";
    public static final String DATATYPE_BYTE = "byte";



    public static Object handleDataType(Long sensorId , Long dataId ,Long data){
        for(SensorConfig sensorConfig : getConfigMap ().getSensorConfig()){
            if(sensorConfig.getSensorId() == sensorId){
                for(AbstractSensorDataSheet abstractSensorDataSheet: sensorConfig.getSensorData().getDataSheets()){
                    if(abstractSensorDataSheet.getDataId().equals(dataId)){
                        switch (abstractSensorDataSheet.getDataType()){
                            case DATATYPE_BOOLEAN:
                                boolean b;
                                b = data >= 1;
                                return b;
                            case DATATYPE_INT:
                            case DATATYPE_DOUBLE:
                                return pow10(abstractSensorDataSheet.getDataMagnitude(),data);
                            case DATATYPE_BYTE:
                                return data;
                            default:
                                return null;
                        }
                    }
                }
            }
        }return null;
    }

    private static Long pow10(int times , Long number){
        if(times >0){
            for(;times>0;times--){
                number = number*10;
            }
        }else if(times == 0){
            return number;
        }else{
            for(;times<0;times++){
                number = number/10;
            }
        }return number;
    }

    private static double pow10(int times,double number){
        return number*Math.pow(10,times);
    }
}
