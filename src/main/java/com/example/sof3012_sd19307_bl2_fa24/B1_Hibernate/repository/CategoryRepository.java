package com.example.sof3012_sd19307_bl2_fa24.B1_Hibernate.repository;

import com.example.sof3012_sd19307_bl2_fa24.B1_Hibernate.entity.Category1;
import com.example.sof3012_sd19307_bl2_fa24.B1_Hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class CategoryRepository {
    // Tang trao doi vs CSDL
    // CRUD
    // J3 => Connection
    // J4 => Session
    private Session s;

    public CategoryRepository() {
        // MO CONG KET NOI (MO 1 LAN)
        s = HibernateUtil.getFACTORY().openSession();
    }

    // CRUD (Them/Sua/Xoa/Detail)
    public List<Category1> getAll() {
        return s.createQuery("FROM Category1 ").list();
    }

    public Category1 getOne(Long id) {
        return s.find(Category1.class, id);
    }

    // Them/Sua/Xoa
    // transation => tinh toan ven
    // gui di => commit
    // quay ve trang thai ban dau => rollback
    public void add(Category1 cate) {
        try {
            // Lay ra tran o thoi diem hien tai
            s.getTransaction().begin();
            // Them => save / saveOrUpdate / persit
            s.persist(cate);
            // Gui yeu cau di
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
        }
    }

    public void update(Category1 cate) {
        try {
            // Lay ra tran o thoi diem hien tai
            s.getTransaction().begin();
            // Update =>  saveOrUpdate / merge
            s.merge(cate);
            // Gui yeu cau di
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
        }
    }

    public void delete(Category1 cate) {
        try {
            // Lay ra tran o thoi diem hien tai
            s.getTransaction().begin();
            // Delete => delete
            s.delete(cate);
            // Gui yeu cau di
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
        }
    }

    public static void main(String[] args) {
        System.out.println(new CategoryRepository().getOne(1L));
    }
}
