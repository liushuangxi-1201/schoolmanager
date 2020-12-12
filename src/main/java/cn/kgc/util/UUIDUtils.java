package cn.kgc.util;

import java.util.UUID;

/**
 * UUID工具类
 */
public class UUIDUtils {

    /**
     * 返回一个没有中划线的32位字符串
     * @return
     */
    public static String getUUID32(){
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * 返回纯数字得uuid
     * @return
     */
    public static Integer getUUIDInOrderId(){
        Integer orderId=UUID.randomUUID().toString().hashCode();
        orderId = orderId < 0 ? -orderId : orderId; //String.hashCode() 值会为空
        return orderId;
    }
}
