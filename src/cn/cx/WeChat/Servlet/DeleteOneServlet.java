package cn.cx.WeChat.Servlet;

import cn.cx.WeChat.Service.ListService;
import cn.cx.WeChat.Service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("serial")
public class DeleteOneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置编码
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        MaintainService maintainService=new MaintainService();
        maintainService.deleteOne(id);
        req.getRequestDispatcher("/list.action").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}
