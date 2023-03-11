package space.shizi.goodluck.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import space.shizi.goodluck.entity.GoodLuck;
import space.shizi.goodluck.model.PageParam;
import space.shizi.goodluck.repository.GoodLuckRepository;

import javax.annotation.Resource;

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
}
