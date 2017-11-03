package com.imooc.dao;

import com.imooc.bean.Message;
import com.imooc.db.DBAccess;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.*;

public class MessageDao {

    public List<Message> queryMessageList(String command, String description) {
        List<Message> messages = new ArrayList<>();
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            Message message = new Message();
            message.setCommand(command);
            message.setDescription(description);
            messages = sqlSession.selectList("Message.querryMessageList",message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return messages;
    }

    public void deleteOne(String id){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try{
            sqlSession = dbAccess.getSqlSession();
            Message message = new Message();
            message.setId(id);
            sqlSession.delete("Message.deleteOne",message);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
    }

    public void deleteBatch(List<String> ids){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try{
            sqlSession = dbAccess.getSqlSession();
            sqlSession.delete("Message.deleteBatch",ids);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
    }

}
