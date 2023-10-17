package com.youcode.live_coding_gathergrid.controller;

import com.youcode.live_coding_gathergrid.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(loadOnStartup = 1)
public class InitialServlet extends HttpServlet {
    @Override
    public void init() {
        EntityManager em = EntityManagerUtil.getEntityManager();
    }
}
