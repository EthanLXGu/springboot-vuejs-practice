package com.ethan.util;

import com.ethan.domain.Result;

/**
 * Created by Ethan L X Gu on 30/03/2017.
 */
public class ResultFoodUtils {
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("Success");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
