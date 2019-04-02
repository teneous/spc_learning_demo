package com.trifail.order.utils;

import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;

public class SerializationUtils {

    private static SerializingConverter serializingConverter = new SerializingConverter();
    private static DeserializingConverter deserializingConverter = new DeserializingConverter();


    public static byte[] objectToByte(Object key){
        return serializingConverter.convert(key);
    }

    public static Object byteToObject(byte[] source){
        return deserializingConverter.convert(source);
    }
}
