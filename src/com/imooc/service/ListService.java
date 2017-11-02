package com.imooc.service;

import com.imooc.bean.Message;
import com.imooc.dao.MessageDao;

import java.util.List;

public class ListService {
    public List<Message> querryMessageList(String command, String description){
        MessageDao messageDao = new MessageDao();
        return messageDao.querryMessageList(command,description);
    }
}
