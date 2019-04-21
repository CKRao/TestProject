package util;

/**
 * 通用工具类
 */
public class CommonUtil {

    /**
     * 判断对象是否为空
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        return obj == null;
    }

    /**
     * 判断对象是否不为空
     * @param obj
     * @return
     */
    public static boolean isNotEmpty(Object obj){
        return obj != null;
    }
}
