package cn.cx.WeChat.Servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import cn.cx.WeChat.Bean.*;
import cn.cx.WeChat.Service.ListService;

@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置编码
        req.setCharacterEncoding("UTF-8");
        String command = req.getParameter("command");
        String description = req.getParameter("description");
        req.setAttribute("command",command);
        req.setAttribute("description",description);
        ListService listService = new ListService();
        req.setAttribute("messageList",listService.queryMessageList(command,description));
        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}
