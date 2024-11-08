package com.example.sof3012_sd19307_bl2_fa24.B1_Hibernate.servlet;

import com.example.sof3012_sd19307_bl2_fa24.B1_Hibernate.entity.Product;
import com.example.sof3012_sd19307_bl2_fa24.B1_Hibernate.repository.ProductRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private ProductRepository repository = new ProductRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = repository.getAll();
        request.setAttribute("list",productList);
        request.getRequestDispatcher("/view/buoi1/product.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
