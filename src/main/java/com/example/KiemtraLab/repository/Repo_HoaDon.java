package com.example.KiemtraLab.repository;

import com.example.KiemtraLab.entity.HoaDon;
import com.example.KiemtraLab.util.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Repo_HoaDon {
    private Session session;
    public Repo_HoaDon(){
        session= HibernateConfig.getFACTORY().openSession();
    }
    public List<HoaDon> getAll(){
        return session.createQuery("select hd from HoaDon hd").list();
    }
    public HoaDon findById(Integer id){
        return session.find(HoaDon.class, id);
    }
    public void delete(Integer id){
        try{
            session.getTransaction().begin();
            session.createQuery("delete from HoaDonChiTiet c where c.hoaDon.id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
           HoaDon hd= session.find(HoaDon.class, id);
           session.delete(hd);
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void update(HoaDon hd){
        try{
            session.getTransaction().begin();
            session.merge(hd);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public List<HoaDon> search(String keyword){
        Query query=  session.createQuery("select hd from HoaDon hd where hd.maHd like :maHd");
        query.setParameter("maHd", keyword);
        return query.list();
    }
}
