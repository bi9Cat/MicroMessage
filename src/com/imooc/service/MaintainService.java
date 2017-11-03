package com.imooc.service;

import com.imooc.dao.MessageDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LP on 2017/11/2.
 */
public class MaintainService {
    public void delteOne(String id) {
        MessageDao dao = new MessageDao();
        dao.deleteOne(id);
    }

    public void delteBatch(String[] ids) {
        MessageDao dao = new MessageDao();
        List<String> idList = new ArrayList<>();
        for (String id : ids) {
            idList.add(id);
        }
        dao.deleteBatch(idList);
    }
}
