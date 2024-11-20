package com.example.sof3012_sd19307_bl2_fa24.B10_Filter.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthFilter", value = {
        // liet ke cac duong dan can phai bat buoc dang nhap moi dung duoc
        "/category/*",
        "/product/*",
        "/DemoServlet"
})
// FILTER
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        // CHI CHAY 1 LAN DUY NHAT => KHOI TAO GIA TRI BAN DAU (DAU TIEN)
        Filter.super.init(config);
        System.out.println("Init filter");
    }

    public void destroy() {
        // Giai phong tai nguyen bo nho
        // CHI CHAY 1 LAN DUY NHAT => KHI KET THUC FILTER ( CUOI CUNG)
        Filter.super.destroy();
        System.out.println("Init destroy");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        // Thuc hien sau khi ham init duoc chay
        // B1: Ep kieu
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        // B2: Goi session
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username1");
        if (username == null) {
            // chua dang nhap
            res.sendRedirect("/login");
        } else {
            // dang nhap roi
            String role = (String) session.getAttribute("role");
            if (role.equalsIgnoreCase("Admin")) {
                //truy cap vao tat ca cac trang
                chain.doFilter(request, response);
            } else if (role.equalsIgnoreCase("NhanVien")) {
                String uri = req.getRequestURI();
                if (uri.startsWith("/category/")) {
                    chain.doFilter(request, response);
                } else {
                    // cam quyen
                    res.sendRedirect("/view/buoi10/403.jsp");
                }
            } else {
                // truong hop con lai => /login
                res.sendRedirect("/login");
            }
        }

    }
}
