package com.sdau.service;

import com.sdau.dao.IVipDao;
import com.sdau.domain.VIP;
import com.sdau.util.PageUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class VipService {

    @Resource
    IVipDao dao;

    /**
     * 	查询
     * @return
     */
    @SuppressWarnings({ "rawtypes" })
    public List<VIP> getAll(Map params){
        // 处理分页参数
        PageUtil.start(params);
        return dao.getAll(params);
    }
    /**
     * 	查询分页
     * @param params
     * @return
     */
    public int getCount(@SuppressWarnings("rawtypes") Map params) {
        return dao.getCount(params);
    }

    /**
     * 	删除
     * @param params
     */
    public int delVIP(@SuppressWarnings("rawtypes") Map params) {
        return dao.delVIP(params);
    }

    /**
     *	添加
     * @param params
     * @return
     */
    public int addVIP(@SuppressWarnings("rawtypes") Map params) {
        return dao.addVIP(params);
    }

    /**
     * 修改
     * @param params
     * @return
     */
    public int editVIP(@SuppressWarnings("rawtypes") Map params){
        return dao.editVIP(params);
    }


    /**
     * 会员状态修改
     * @param params
     * @return
     */
    // 注销
    public int kill(@SuppressWarnings("rawtypes") @RequestParam Map params){
        return dao.kill(params);
    }
    // 恢复
    public int recover(@SuppressWarnings("rawtypes") @RequestParam Map params){
        return dao.recover(params);
    }


}
