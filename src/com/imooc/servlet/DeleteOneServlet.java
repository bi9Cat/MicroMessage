package com.imooc.servlet;

import com.imooc.bean.Message;
import com.imooc.service.ListService;
import com.imooc.service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by LP on 2017/11/2.
 */
public class DeleteOneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        MaintainService maintainService = new MaintainService();
        maintainService.delteOne(id);
        request.getRequestDispatcher("/List.action").forward(request, response);
    }
}
