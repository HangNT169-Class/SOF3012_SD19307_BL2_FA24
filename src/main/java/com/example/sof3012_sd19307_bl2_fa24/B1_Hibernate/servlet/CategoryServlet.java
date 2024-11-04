package com.example.sof3012_sd19307_bl2_fa24.B1_Hibernate.servlet;

import com.example.sof3012_sd19307_bl2_fa24.B1_Hibernate.entity.Category1;
import com.example.sof3012_sd19307_bl2_fa24.B1_Hibernate.repository.CategoryRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet1", value = {
        // liet ke cac duong dan
        "/category/hien-thi", // GET
        "/category/detail",// GET
        "/category/delete", // GET
        "/category/view-update", // GET
        "/category/update", // POST
        "/category/view-add",// GET
        "/category/add",// POST
        "/category/search"// GET
})
public class CategoryServlet extends HttpServlet {

    private CategoryRepository categoryRepository = new CategoryRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay uri tren duong dan
        // localhost:8080/category/hien-thi => url
        // http://localhost:8080/category/hien-thi
        // https://meet.google.com/mwn-iyun-zow?authuser=0
        // Java => http
        // C# => https
//        request.getRequestURL() => StringBuffer
        // uri => /category/hien-thi
        // uri: la 1 phan cua url
        // B1: Lay uri hien tai
        String uri = request.getRequestURI();
//        StringBuffer url = request.getRequestURL();
        System.out.println(uri);
//        System.out.println(url);
        // url : http/https()://domain(localhost - diachiip)/path/uri
        // 6 do get
        // kiem tra chua
        if (uri.contains("hien-thi")) {
            // hien thi
            this.hienThiCate(request, response);
        } else if (uri.contains("detail")) {
            // detail
            this.detailCate(request, response);
        } else if (uri.contains("delete")) {
            // delete
            this.deleteCate(request, response);
        } else if (uri.contains("view-update")) {
            // view update
            this.viewUpdateCate(request, response);
        } else if (uri.contains("view-add")) {
            // view add
            this.viewAddCate(request, response);
        } else {
            // search
            this.searchCate(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            // update
            this.updateCate(request, response);
        } else {
            // add
            this.addCate(request, response);
        }
    }

    private void addCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void searchCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewAddCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdateCate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay gia tri
        String id = request.getParameter("b");
        // B2: Lay ra doi tuong can tim
        Category1 cate = categoryRepository.getOne(Long.valueOf(id));
        // B3: Day gia tri
        request.setAttribute("cate1", cate);
        // B4: Chuyen trang
        request.getRequestDispatcher("/view/buoi1/update-cate.jsp").forward(request, response);
    }

    private void deleteCate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // B1: Lay gia tri tren duong dan
        String id1 = request.getParameter("a2");
        // B2: Xoa
        Category1 cate = categoryRepository.getOne(Long.valueOf(id1));
        categoryRepository.delete(cate);
        // B3: Quay lai trang chu :/category/hien-thi
        response.sendRedirect("/category/hien-thi");
    }

    private void detailCate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay gia tri
        String id = request.getParameter("id");
        // B2: Lay ra doi tuong can tim
        Category1 cate = categoryRepository.getOne(Long.valueOf(id));
        // B3: Day gia tri
        request.setAttribute("cate1", cate);
        // B4: Chuyen trang
        request.getRequestDispatcher("/view/buoi1/detail-cate.jsp").forward(request, response);
    }

    private void hienThiCate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category1> listCate = categoryRepository.getAll();
        // Day gia tri cua list => jsp (request.setAttribute)
        request.setAttribute("a1", listCate);
        // Chuyen trang jsp
        request.getRequestDispatcher("/view/buoi1/categorys.jsp").forward(request, response);
    }

    private void updateCate(HttpServletRequest request, HttpServletResponse response) {
    }
}
