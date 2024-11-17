package com.example.sof3012_sd19307_bl2_fa24.B9_ScopeTrongJSPServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "DemoServlet", value = "/DemoServlet")
public class DemoServlet extends HttpServlet {
    /**
     * Doi vs Java - OOP : Pham vi truy cap cua bien/ham/class(access modifier): public, protected, default, private
     * Doi vs JSP/Servlet: PHAM VI TRUY CAP (request duoc gui di tu phia client) - KHACH HANG TOI NHA HANG
     * => Co cac pham vi tru cap khac nhau (SCOPE TRONG JSP & SERVLET)
     * + application
     * + session
     * + request
     * + page
     * VD:
     * request.setAttribute(ts1,ts2)
     * session.setAttribute(ts1,ts2)
     * application.setAttribute(ts1,ts2)
     * component 1 - file JSP 1                                         component 3 - file JSP 3
     *                                  Pham vi truy cap (request)
     * component 2 - file JSP 2                                         component 4 - file JSP 4
     * Tat ca cac scope (deu co cac ham)
     * + ts1: Ten bien ma jsp se dung : String
     * + ts2: Gia tri ma duoc truyen cho ts1 - Object: Co the la 1 String, 1 so, 1 Object - Doi tuong, 1 List doi tuong
     * Phia servlet :
         * <scope>.setAttribute(ts1,ts2)
         * <scope>.getAttribute(ts1)
         * <scope>.removeAttribute(ts1)
     * Phia jsp:
     *      tenscopeScope.tenbien
     * VD: applicationScope.message
     * 1. Request:
     *     + Chi co gia tri ton tai tu: servlet 1 -> jsp1 (DemoServlet -> buoi9.jsp)
     *    => servlet 2 -> jsp1 ( Khai bao lai gia tri cua bien can day di)
     *    => Gia tri 1 chieU (servlet -> jsp)
     *    Neu servlet khong co setAttribute (Tuc la k co gia tri) => JSP k co gia tri de hien thi du lieu
     *  Timeout(Thoi gian song) cua bien request : CHI TON TAI TRONG CAI REQUEST DAY MA THOI
     *  => CHI TON TAI (SERVLET1 -> JSP1)
     *  2. Page
     *   => Tuong tu vs request tuy nhien KHONG DUNG DUOC O SERVLET (CHI DUNG DUOC O JSP)
     *   => CHI XU LY DC JSP (KHONG CHIA SERVLET DU LIEU VS SERVLET / JSP KHAC)
     *   => CHI TON TAI TRONG JSP HIEN TAI
     *   => LUU O CUC BO
     *   3. Application
     *   => Toan cuc
     *   => servlet 1 => JSP 1
     *   => Van co the goi dc o servlet 2, jsp2
     *   => Thuong se dung de luu cache tren trinh duyet
     *   table -> ds sp  -> detail -> getOne
     *   => ton performance
     *   => Tu lan t2 detail ( KIEM TRA TRONG CACHE XEM DA TON TAI SP NAY HAY LA CHUA)
     *  => for => KHONG BAO GOI GET ALL/GET ONE ( GOI CAC HAM TRUY VAN)
     *  Chu y: PHAI CHAY CAI NOI APPLICATION DUOC SINH RA TRUOC
     *  HOAT DONG TOI KHI MA SERVER DUNG (STOP HAN) => TAT CHUONG TRINH
     *  TIMEOUT => TON TAI TU LUC BAT DAU CHAY CHUONG TRINH => DEN LUC KET THUC CHUONG TRINH
     *  => PHU HOP VS VIEC LUU CACHE
     *  4. Session
     *   => Dung de chia se du lieu toi cac request hoat dong TRONG 1 PHIEN LAM VIEC
     *   SERVLET 1 -> JSP 1
     *   SERVLET 2, JSP2 CO THE GOI DC GIA TRI
     *   DEFAULT 1 PHIEN SESSION ( 30 PHUT )
     *   => HOAN TOAN CAU HINH TIMEOUT(THOI GIAN SONG) SESSION TRONG WEB.XML
     *
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message1", "Scope JSP & Servlet - Request");
        // Goi application
        ServletContext application = getServletContext();
        application.setAttribute("message3","Scope JSP & Servlet - Application");
        // Goi session
        HttpSession session = request.getSession();
        session.setAttribute("message4","Scope JSP & Servlet - Session");
        // C1: Chuyen trang : NHUNG MANG DU LIEU DI
        request.getRequestDispatcher("/view/buoi9/buoi9.jsp").forward(request, response);
        // C2: => CHUYEN TRANG
//        response.sendRedirect("/view/buoi9/buoi9.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
