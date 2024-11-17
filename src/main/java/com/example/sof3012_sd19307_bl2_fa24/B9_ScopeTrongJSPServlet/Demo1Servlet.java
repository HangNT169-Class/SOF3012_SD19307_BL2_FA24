package com.example.sof3012_sd19307_bl2_fa24.B9_ScopeTrongJSPServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "Demo1Servlet", value = "/Demo1Servlet")
public class Demo1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message1", "Demo o servlet 2");
        // Goi session/application ben servlet
        HttpSession session = request.getSession();
        String str = (String) session.getAttribute("message4");
        // Xu ly gi thi xu ly
        request.setAttribute("str1", str);
        request.getRequestDispatcher("/view/buoi9/buoi9.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
