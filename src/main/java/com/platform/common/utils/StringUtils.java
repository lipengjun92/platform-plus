/*
 * 项目名称:platform-plus
 * 类名称:StringUtils.java
 * 包名称:com.platform.common.utils
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2019/1/10 19:18    李鹏军      初版完成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.platform.common.utils;

import java.util.Collection;
import java.util.Map;

/**
 * String工具类
 *
 * @author 李鹏军
 */
public class StringUtils {

    public static boolean isEmpty(Object str) {
        return str == null || str.toString().length() == 0;
    }

    public static boolean isNotBlank(String str) {
        return !StringUtils.isBlank(str);
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param parentId
     * @param maxId
     * @return
     */
    public static String addOne(String parentId, String maxId) {
        int ten = 10;
        if (Constant.STR_ZORE.equals(parentId)) {
            parentId = "";
        }
        if (isNullOrEmpty(maxId)) {
            return parentId + "01";
        }

        maxId = maxId.substring(maxId.length() - 2, maxId.length());

        int result = Integer.parseInt(maxId) + 1;

        if (result < ten) {
            return parentId + "0" + result;
        } else {
            return parentId + result + "";
        }
    }

    /**
     * 判断对象或对象数组中每一个对象是否为空: 对象为null，字符序列长度为0，集合类、Map为empty
     *
     * @param obj
     * @return
     */
    public static boolean isNullOrEmpty(Object obj) {
        if (obj == null) {
            return true;
        }

        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        }

        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }

        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }

        if (obj instanceof Object[]) {
            Object[] object = (Object[]) obj;
            if (object.length == 0) {
                return true;
            }
            boolean empty = true;
            for (int i = 0; i < object.length; i++) {
                if (!isNullOrEmpty(object[i])) {
                    empty = false;
                    break;
                }
            }
            return empty;
        }
        return false;
    }

    /**
     * 生成key
     *
     * @param prefix     前缀
     * @param className  类名
     * @param methodName 方法名
     * @return prefix className.methodName
     */
    public static String genKey(String prefix, String className, String methodName) {
        return prefix + "userId_" +
                ShiroUtils.getUserId() +
                "_" +
                className +
                "." +
                methodName;
    }
}
