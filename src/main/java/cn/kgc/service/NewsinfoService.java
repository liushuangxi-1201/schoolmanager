package cn.kgc.service;

import cn.kgc.entity.Newsinfo;
import com.github.pagehelper.PageInfo;
import java.util.List;

public interface NewsinfoService {
    /**
     * 查询所有公告
     * @return
     */
    PageInfo<Newsinfo> getAllNewsinfo(Integer pageNum, Integer pageSize);
}
