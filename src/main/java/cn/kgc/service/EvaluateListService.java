package cn.kgc.service;

import cn.kgc.entity.EvaluateList;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EvaluateListService {
    /**
     * 查询所有教评题目
     * @return
     */
    PageInfo<EvaluateList> findAll(Integer pageIndex,Integer pageSize);
    /**
     * 新增教评问题
     * @param evaluateList
     * @return
     */
    Integer add(EvaluateList evaluateList);

    /**
     * 删除教评问题
     * @param elid
     * @return
     */
    Integer del(Integer elid);

    /**
     * 修改教评问题
     * @param evaluateList
     * @return
     */
    Integer update(EvaluateList evaluateList);
}
