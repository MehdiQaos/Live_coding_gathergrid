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

@WebServlet("/create-user")
public class CreateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        EntityManager em = EntityManagerUtil.getEntityManager();
        UserRepository userRepository = new UserRepository(em);
        UserService userService = new UserService(userRepository);

        User user = new User(firstName, lastName, email, password);
        userService.createUser(user); // TODO: handle exceptions, and redirect to "/create-user" with error message
        resp.sendRedirect("list-users");
    }
}
