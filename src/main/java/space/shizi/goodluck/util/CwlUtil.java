package space.shizi.goodluck.util;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import space.shizi.goodluck.entity.GoodLuck;

import java.util.List;

public class CwlUtil {
    public static List<GoodLuck> getResult(String response) {
        JSONObject body = JSONUtil.parseObj(response);
        JSONArray result = body.getJSONArray("result");
        return JSONUtil.toList(result, GoodLuck.class);
    }
}
