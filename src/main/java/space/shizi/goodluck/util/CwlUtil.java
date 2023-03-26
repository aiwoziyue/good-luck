package space.shizi.goodluck.util;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import space.shizi.goodluck.entity.GoodLuck;

import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Slf4j
public class CwlUtil {
    private static final String url = "http://www.cwl.gov.cn/cwl_admin/front/cwlkj/search/kjxx/findDrawNotice";

    public static List<GoodLuck> getResult(String response) {
        JSONObject body = JSONUtil.parseObj(response);
        JSONArray result = body.getJSONArray("result");
        return result.toList(GoodLuck.class);
    }

    /**
     * @param params ?name=ssq&pageNo=1&pageSize=1&systemType=PC
     * @return List<GoodLuck>
     */
    public static List<GoodLuck> page(Map<String, Object> params) {
        HttpResponse response = HttpRequest.get(url + "?" + HttpUtil.toParams(params)).executeAsync();
        int responseCode = response.getStatus();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            if (responseCode == HttpURLConnection.HTTP_MOVED_PERM
                    || responseCode == HttpURLConnection.HTTP_MOVED_TEMP
                    || responseCode == HttpURLConnection.HTTP_SEE_OTHER) {
                response = HttpRequest.get(url + "?" + HttpUtil.toParams(params)).executeAsync();
            } else {
                log.error("CwlUtil.page1 code:{},{}", response.getStatus(), response.body());
                return Collections.emptyList();
            }
        }
        responseCode = response.getStatus();
        String body = response.body();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            log.info("page:{}", body);
            return getResult(body);
        } else {
            log.error("CwlUtil.page2 code:{},{}", response.getStatus(), response.body());
            return Collections.emptyList();
        }
    }
}
