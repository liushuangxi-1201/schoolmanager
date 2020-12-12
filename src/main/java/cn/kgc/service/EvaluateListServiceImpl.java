package cn.kgc.service;

import cn.kgc.entity.EvaluateList;
import cn.kgc.mapper.EvaluateListMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EvaluateListServiceImpl implements EvaluateListService {
    @Autowired
    private EvaluateListMapper evaluateListMapper;

    @Override
    public PageInfo<EvaluateList> findAll(Integer pageIndex,Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        PageInfo pageInfo = new PageInfo(evaluateListMapper.findAll());
        return pageInfo;
    }

    @Override
    public Integer add(EvaluateList evaluateList) {
        return evaluateListMapper.add(evaluateList);
    }

    @Override
    public Integer del(Integer elid) {
        return evaluateListMapper.del(elid);
    }

    @Override
    public Integer update(EvaluateList evaluateList) {
        return evaluateListMapper.update(evaluateList);
    }

}
