package com.example.KiemtraLab.repository;

import com.example.KiemtraLab.entity.KhachHang;
import com.example.KiemtraLab.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class Repo_KhachHang {
    private Session session;
    public Repo_KhachHang(){
        session= HibernateConfig.getFACTORY().openSession();
    }
    public List<KhachHang> getAll(){
        return session.createQuery("select kh from KhachHang kh").list();
    }
    public KhachHang findById(Integer id){
        return session.find(KhachHang.class, id);
    }
}
