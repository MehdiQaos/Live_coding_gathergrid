package com.youcode.live_coding_gathergrid.controller;

import com.youcode.live_coding_gathergrid.model.User;
import com.youcode.live_coding_gathergrid.repository.UserRepository;
import com.youcode.live_coding_gathergrid.service.UserService;
import com.youcode.live_coding_gathergrid.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/list-users", ""} )
public class ListUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = EntityManagerUtil.getEntityManager();
        UserRepository userRepository = new UserRepository(em);
        UserService userService = new UserService(userRepository);

        List<User> users = userService.getAllUsers();
        req.setAttribute("users", users);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
