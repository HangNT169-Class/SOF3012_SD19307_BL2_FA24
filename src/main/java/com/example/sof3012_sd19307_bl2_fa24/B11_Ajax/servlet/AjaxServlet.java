package com.example.sof3012_sd19307_bl2_fa24.B11_Ajax.servlet;

import com.example.sof3012_sd19307_bl2_fa24.B11_Ajax.entity.SinhVien;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AjaxServlet", value = "/api/ajax/demo")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: fake data
        SinhVien sv =
                new SinhVien("HE13041", "Nguyen thuy hang", 10, "Ky thuat phan mem");
        // B2: Convert to Json
        Gson gson = new Gson();
        String data = gson.toJson(sv);
        // B3: Set type la json
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        // Gui du lieu
        out.println(data);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
