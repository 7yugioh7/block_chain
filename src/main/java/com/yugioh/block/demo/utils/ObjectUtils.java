package com.yugioh.block.demo.utils;

import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by admin on 2017/7/18.
 */
@Component
public class ObjectUtils {

    /**
     * 对象深拷贝
     *
     * @param src 拷贝源
     * @param <T> 对象
     * @return 考背后的对象
     */
    public <T> List<T> deepCopy(List<T> src) {
        try {
            if (src == null) {
                return null;
            }
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(src);

            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            @SuppressWarnings("unchecked")
            List<T> dest = (List<T>) in.readObject();
            return dest;
        } catch (Exception e) {
            return null;
        }
    }

}
