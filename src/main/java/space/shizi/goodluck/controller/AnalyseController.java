package space.shizi.goodluck.controller;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/analysis")
public class AnalyseController {

    @GetMapping("/probability")
    public Map<String, Integer> probabilityAnalysis() {
        Map<String, Integer> temp = new HashMap<>();

        URL resource = this.getClass().getClassLoader().getResource("static/good_luck.json");
        if (Objects.nonNull(resource)) {
            JSONArray array = JSONUtil.readJSONArray(new File(resource.getPath()), Charset.defaultCharset());

            for (int i = 0; i < array.size(); i++) {
                JSONObject object = array.getJSONObject(i);
                String red = object.getStr("red");
                String[] split = red.split(",");
                for (String num : split) {
                    String key = "red_" + num;
                    Integer value = temp.getOrDefault(key, 0);
                    temp.put(key, value + 1);
                }
                String blue = object.getStr("blue");
                String key2 = "blue_" + blue;
                Integer value2 = temp.getOrDefault(key2, 0);
                temp.put(key2, value2 + 1);
            }
        }
        return temp;
    }
}
