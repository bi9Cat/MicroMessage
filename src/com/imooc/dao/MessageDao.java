package com.imooc.dao;

import com.imooc.bean.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDao {
    public List<Message> querryMessageList(String command,String description){
        List<Message> messageList = new ArrayList<Message>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/micro_message", "root", "123456");
            StringBuilder sql = new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from MESSAGE where 1=1");
            List<String> params = new ArrayList<>();
            if (command != null && !"".equals(command.trim())) {
                sql.append(" and COMMAND = ?");
                params.add(command);
            }
            if (description != null && !"".equals(description.trim())) {
                sql.append(" and DESCRIPTION like '%'?'%'");
                params.add(description);
            }
            PreparedStatement statement = conn.prepareStatement(sql.toString());
            for(int i =0;i<params.size();i++){
                statement.setString(i+1,params.get(i));
            }
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Message message = new Message();
                message.setId(rs.getString("ID"));
                message.setCommand(rs.getString("COMMAND"));
                message.setDescription(rs.getString("DESCRIPTION"));
                message.setContent(rs.getString("CONTENT"));
                messageList.add(message);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messageList;
    }
}
