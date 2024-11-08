package com.example.sof3012_sd19307_bl2_fa24.B1_Hibernate.repository;

import com.example.sof3012_sd19307_bl2_fa24.B1_Hibernate.entity.Category1;
import com.example.sof3012_sd19307_bl2_fa24.B1_Hibernate.util.HibernateUtil;
import jakarta.persistence.Query;
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
        System.out.println("aaa");
        return s.createQuery("FROM Category1 ").list();
    }

    // SELECT * FROM a WHERE id = ?
    // C1: Find
    public Category1 getOne(Long id) {
        return s.find(Category1.class, id);
    }

    // C2: Dung truyen param
    public Category1 getOne2(Long id) {
        // B1: Viet cau truy van
        // Trong hibernate truy HQL => KHONG CO SELECT *
//        String hql = "SELECT c FROM Category1 c WHERE c.id1 = ?1";
        String hql = "SELECT c FROM Category1 c WHERE c.id1 = :a";
        // B2: Tao query
        Query q = s.createQuery(hql);
        // B3: Set gia tri cho cac bien can truyen
//        q.setParameter(1,id);
        q.setParameter("a", id);
        // B4: Tra ve doi tuong
        return (Category1) q.getSingleResult(); // LAY RA KET QUA DON LE
    }

    // LIKE %% => List
    public List<Category1> searchName(String name) {
        String hql = "SELECT c FROM Category1 c WHERE c.categoryName LIKE :name1";
        Query query = s.createQuery(hql);
        query.setParameter("name1", "%" + name + "%");
        return query.getResultList(); // LAY RA ALL LIST
    }
    // Sap xep them order by
    // Phan trang => SQL / HQL

    /**
     * mieu ta cua the ham nay lam gi
     *
     * @param pageNo:   so Trang - vi tri cua trang (1,2,3...)
     * @param pageSize: so luong phan tu trong 1 trang
     * @return ham nay tra ra gi
     */
    // Trang dau tien bat dau bang 0
    // HQL => createQuery
    // SQL => createNativeQuery
    public List<Category1> phanTrangSQL(int pageNo, int pageSize) {
        int offset = pageNo * pageSize;
        //B1: Viet cau lenh SQL
        String sql = """
            select * from category
            ORDER BY id
            OFFSET :os ROWS
            FETCH NEXT :ps ROWS ONLY
        """;
        // B2: Tao query
        Query query = s.createNativeQuery(sql, Category1.class);
        // B3: Set ts gia tri
        query.setParameter("os", offset); // BO QUA GIA TRI CUA OFFSET => TIEN DEN GIA OFFSET + 1
        query.setParameter("ps", pageSize); // SO LUONG PHAN TU 1 TRANG
        return query.getResultList();
    }

    public List<Category1> phanTrangHQL(int pageNo, int pageSize) {
        int offset = pageNo * pageSize;
        //B1: Viet cau lenh SQL
        String hql = "SELECT cate FROM Category1 cate ORDER BY cate.id1";
        // B2: Tao query
        Query query = s.createQuery(hql, Category1.class);
        // B3: Set min va max cua 1 trang
        query.setFirstResult(offset); // BO QUA GIA TRI NAY => GIA TRI + 1
        query.setMaxResults(pageSize); // SO LUONG PHAN TU 1 TRANG
        return query.getResultList();
    }

    public static void main(String[] args) {
        System.out.println(new CategoryRepository().phanTrangHQL(1,4));
//        System.out.println(new CategoryRepository().getOne2(1L));
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


}
