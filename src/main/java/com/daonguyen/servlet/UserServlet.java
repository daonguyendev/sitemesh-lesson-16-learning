package com.daonguyen.servlet;

import com.daonguyen.dao.UserDao;
import com.daonguyen.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "userServlet", urlPatterns = {"/user", "/user/details", "/user/add", "/user/edit", "/user/remove"})
public class UserServlet extends HttpServlet {

    private UserDao userDao = null;

    @Override
    public void init() throws ServletException {
        userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String action = req.getServletPath();

        switch (action) {
            case "/user":
                req.setAttribute("users", userDao.findAllOfUsers());
                req.getRequestDispatcher("/WEB-INF/view/user/index.jsp").forward(req, resp);
                break;
            case "/user/details":
                req.setAttribute("user", userDao.findUserById(Integer.parseInt(req.getParameter("id"))));
                req.getRequestDispatcher("/WEB-INF/view/user/details.jsp").forward(req, resp);
                break;
            case "/user/add":
                req.getRequestDispatcher("/WEB-INF/view/user/add.jsp").forward(req, resp);
                break;
            case "/user/edit":
                User user = userDao.findUserById(Integer.valueOf(req.getParameter("id")));
                req.setAttribute("user", user);
                req.getRequestDispatcher("/WEB-INF/view/user/edit.jsp").forward(req, resp);
                break;
            case "/user/remove":
                userDao.remove(Integer.valueOf(req.getParameter("id")));
                resp.sendRedirect(req.getContextPath() + "/user");
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String action = req.getServletPath();

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullName");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String avatar = req.getParameter("avatar");
        Integer roleId = Integer.valueOf(req.getParameter("roleId"));

        User user = new User(email, password, fullName, address, phone, avatar, roleId);

        switch (action) {
            case "/user/add":
                userDao.add(user);
                break;
            case "/user/edit":
                Integer id = Integer.valueOf(req.getParameter("id"));
                User editingUser = userDao.findUserById(id);
                editingUser.setEmail(email);
                editingUser.setPassword(password);
                editingUser.setFullName(fullName);
                editingUser.setAddress(address);
                editingUser.setPhone(phone);
                editingUser.setAvatar(avatar);
                editingUser.setRoleId(roleId);
                userDao.edit(editingUser);
                break;
            default:
                break;
        }
        resp.sendRedirect(req.getContextPath() + "/user");
    }
}
