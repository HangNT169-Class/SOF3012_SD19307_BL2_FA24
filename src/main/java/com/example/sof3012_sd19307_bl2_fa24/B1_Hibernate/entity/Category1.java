//package com.example.sof3012_sd19307_bl2_fa24.B1_Hibernate.entity;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//import java.util.List;
//
//// ctrl Alt O  => XOA IMPORT THUA
//// ctrl alt L => FORMAT CODE
//// import * => import wildcard
//// => import toan bo ham co trong thu vien dung
//@Table(name = "category")
//@Entity // BAT BUOC THEM ENTITY => DE XAC DINH DAY LA THUC THE
//@AllArgsConstructor // contructor full ts
//@NoArgsConstructor // contructor k ts
//@Getter
//@Setter
//@ToString
//@Builder // Contructor tuy y ts
//public class Category1 {
//    /**
//     * J3: JDBC ( Java Database Connectity)
//     * => Truy van tren SQL
//     * J4: Hibernate
//     * => Truy van tren HQL (Hibernate Query Language) - Thuc the (CLASS)
//     * ORM(OBJECT RELATIONAL MAPPING) => MAPPING DOI TUONG (ENTITY)
//     * + Table
//     * + Column
//     * + Moi Quan he
//     */
//
//    // MAPPING XONG KHOA CHINH
//    @Id // KHOA CHINH => THEM @ID
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // Khoa chinh tu tang
//    @Column(name = "id")
//    private Long id1;
//
//    @Column(name = "category_code")
//    private String categoryCode;
//
//    @Column(name = "category_name")
//    private String categoryName;
//
////    @OneToMany
////    private List<Product>products;
//}
