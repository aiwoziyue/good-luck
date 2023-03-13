package space.shizi.goodluck.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import space.shizi.goodluck.entity.GoodLuck;
import space.shizi.goodluck.model.PageParam;
import space.shizi.goodluck.service.ApiService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/good/luck")
public class ApiController {
    @Resource
    private ApiService apiService;

    @GetMapping("/last")
    public GoodLuck lastGoodLuck() {
        return apiService.lastGoodLuck();
    }

    @GetMapping("/list")
    public Page<GoodLuck> listGoodLuck(PageParam pageParam) {
        return apiService.listGoodLuck(pageParam);
    }

    @GetMapping("/append")
    public List<GoodLuck> append(@RequestParam Map<String, Object> params) {
        return apiService.append(params);
    }

}
