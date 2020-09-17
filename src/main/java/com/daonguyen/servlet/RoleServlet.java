package com.daonguyen.servlet;

import com.daonguyen.dao.RoleDao;
import com.daonguyen.entity.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "roleServlet", urlPatterns = {"/role", "/role/details", "/role/add", "/role/edit", "/role/remove"})
public class RoleServlet extends HttpServlet {

    private RoleDao roleDao = null;

    @Override
    public void init() throws ServletException {
        roleDao = new RoleDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String action = req.getServletPath();

        switch (action) {
            case "/role":
                req.setAttribute("roles", roleDao.findAllOfRoles());
                req.getRequestDispatcher("/WEB-INF/view/role/index.jsp").forward(req, resp);
                break;
            case "/role/details":
                req.setAttribute("role", roleDao.findRoleById(Integer.parseInt(req.getParameter("id"))));
                req.getRequestDispatcher("/WEB-INF/view/role/details.jsp").forward(req, resp);
                break;
            case "/role/add":
                req.getRequestDispatcher("/WEB-INF/view/role/add.jsp").forward(req, resp);
                break;
            case "/role/edit":
                Role role = roleDao.findRoleById(Integer.valueOf(req.getParameter("id")));
                req.setAttribute("role", role);
                req.getRequestDispatcher("/WEB-INF/view/role/edit.jsp").forward(req, resp);
                break;
            case "/role/remove":
                roleDao.remove(Integer.valueOf(req.getParameter("id")));
                resp.sendRedirect(req.getContextPath() + "/role");
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

        String name = req.getParameter("name");
        String description = req.getParameter("description");

        Role role = new Role(name, description);

        switch (action) {
            case "/role/add":
                roleDao.add(role);
                break;
            case "/role/edit":
                Integer id = Integer.valueOf(req.getParameter("id"));
                Role editingRole = roleDao.findRoleById(id);
                editingRole.setName(role.getName());
                editingRole.setDescription(role.getDescription());
                roleDao.edit(editingRole);
                break;
            default:
                break;
        }
        resp.sendRedirect(req.getContextPath() + "/role");
    }
}
