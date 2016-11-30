package com.xuc.wex.common.util.uuidcode;
import java.util.UUID;

/**
 * 自动生成菜品编号
 * @author ZZZ
 *
 */

public class uuidcode {
    public static String autoCode(){
        return UUID.randomUUID().toString();
    }
}
