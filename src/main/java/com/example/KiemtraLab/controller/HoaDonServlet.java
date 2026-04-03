package com.example.KiemtraLab.controller;

import com.example.KiemtraLab.entity.HoaDon;
import com.example.KiemtraLab.entity.KhachHang;
import com.example.KiemtraLab.repository.Repo_HoaDon;
import com.example.KiemtraLab.repository.Repo_KhachHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "HoaDonServlet", value = {"/HoaDonServlet",
        "/hoa-don/hien-thi",
        "/hoa-don/delete",
        "/hoa-don/view-update",
        "/hoa-don/update",
        "/hoa-don/search"
})
public class HoaDonServlet extends HttpServlet {
    Repo_HoaDon repo= new Repo_HoaDon();
    Repo_KhachHang repo1= new Repo_KhachHang();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String uri= request.getRequestURI();
    if(uri.contains("hien-thi")){
        hienThi(request, response);
    }else if(uri.contains("view-update")){
        viewUpdate(request, response);
    }else if(uri.contains("delete")){
        delete(request, response);
    }else if(uri.contains("search")){
        search(request, response);
    }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword= request.getParameter("keyword");
        request.setAttribute("list", repo.search(keyword));
        request.setAttribute("list1", repo1.getAll());
        request.getRequestDispatcher("/hoa-don/hien-thi.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id= Integer.parseInt(request.getParameter("id"));
        repo.delete(id);
        response.sendRedirect("/hoa-don/hien-thi");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id= Integer.parseInt(request.getParameter("id"));
        request.setAttribute("hd", repo.findById(id));
        request.setAttribute("list", repo.getAll());
        request.setAttribute("list1", repo1.getAll());
        request.getRequestDispatcher("/hoa-don/view-update.jsp").forward(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", repo.getAll());
        request.setAttribute("list1", repo1.getAll());
        request.getRequestDispatcher("/hoa-don/hien-thi.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String uri= request.getRequestURI();
      if(uri.contains("update")){
          update(request, response);
      }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id= Integer.parseInt(request.getParameter("id"));
        String maHd= request.getParameter("ma");
        float tongTienHang= Float.parseFloat(request.getParameter("tongTienHang"));
        float tienThua= Float.parseFloat(request.getParameter("tienThua"));
        String ghiChu= request.getParameter("ghiChu");
        String maGiaoDich= request.getParameter("maGiaoDich");
        Integer idKh= Integer.parseInt(request.getParameter("idkh"));
        KhachHang kh= repo1.findById(idKh);
        HoaDon hd= new HoaDon(id, maHd, tongTienHang, tienThua, ghiChu, maGiaoDich, kh);
        repo.update(hd);
        response.sendRedirect("/hoa-don/hien-thi");
    }
}
