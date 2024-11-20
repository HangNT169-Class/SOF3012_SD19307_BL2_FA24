package com.example.sof3012_sd19307_bl2_fa24.B10_Filter.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "Login", value = {
        "/login",
        "/dang-xuat"
})
public class LoginServlet extends HttpServlet {
    /**
     * Authentication : CHECK TAI KHOAN XEM CO TON TAI TRONG HE THONG HAY KHONG
     * => CHECK SU TON TAI XEM CO TRONG CSDL BANG USER HAY KHONG
     * Author :
     * SAU AUTHEN => PHAN QUYEN .
     * CHECK XEM TAI KHOAN DUOC QUYEN TRUY CAP CAC CHUC NANG NAO
     * HTTP STATUS :
     * 401 :=> CHUA AUTHEN -> TAI KHOAN K TOI TAI TRONG HE THONG => CHET O AUTHEN
     * 403: => CAM QUYEN -> ( DA DANG NHAP) => CHET O AUTHOR
     * ... 200,201,404,500,405,400...
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("login")) {
            req.getRequestDispatcher("/view/buoi10/Login.jsp").forward(req, resp);
        } else {
            // dang xuat => LOAI BO TOAN BO SESSION
            // C1: XOA LAN LUOT CAC SESSION
            HttpSession session = req.getSession();
//            session.removeAttribute("username1");
//            session.removeAttribute("role");
            // C2: XOA TAT
            session.invalidate();
            resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("u1");
        String pass = req.getParameter("p1");
        if ((user.equalsIgnoreCase("hangnt169") &&
                pass.equals("123456")) ||
                (user.equalsIgnoreCase("nguyenvv4")
                        && pass.equals("1234567"))) {
            // thanh cong
            HttpSession session = req.getSession();
            session.setAttribute("username1", user);
            // set quyen
            if (user.equalsIgnoreCase("HangNT169")) {
                // role admin
                session.setAttribute("role", "Admin");
            } else {
                session.setAttribute("role", "NhanVien");
            }
            resp.sendRedirect("/category/hien-thi");
//            req.getRequestDispatcher("/view/buoi10/ket-qua.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "tai khoan hoac mat khau khong dung");
            req.getRequestDispatcher("/view/buoi10/Login.jsp").forward(req, resp);
        }
    }
}
