package space.shizi.goodluck.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import space.shizi.goodluck.entity.GoodLuck;
import space.shizi.goodluck.model.PageParam;
import space.shizi.goodluck.repository.GoodLuckRepository;
import space.shizi.goodluck.util.CwlUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ApiService {
    @Resource
    private GoodLuckRepository goodLuckRepository;

    public GoodLuck lastGoodLuck() {
        return goodLuckRepository.findFirstByOrderByCodeDesc();
    }

    public Page<GoodLuck> listGoodLuck(PageParam pageParam) {
        return goodLuckRepository.findAll(PageRequest.of(pageParam.getPage(), pageParam.getSize()));
    }

    public List<GoodLuck> append(Map<String, Object> params) {
        List<GoodLuck> goodLuckList = CwlUtil.page(params);
        return goodLuckRepository.saveAll(goodLuckList);
    }
}
