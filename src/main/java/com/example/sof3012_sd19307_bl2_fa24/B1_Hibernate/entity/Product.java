//package com.example.sof3012_sd19307_bl2_fa24.B1_Hibernate.entity;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@Table(name = "product")
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//public class Product {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "product_code")
//    private String productCode;
//
//    @Column(name = "product_name")
//    private String productName;
//
//    @Column
//    private Float price;
//
//    @Column
//    private String description;
//
//    // 1 Product -> N Category
//    // 1 Category -> 1 Product
//
//    /**
//     * 1-1: One To One
//     * 1-N: One To Many
//     * N-1: Many To One
//     * N-N: Many To Many
//     */
//    /**
//     * fetch: lay ra gia tri doi tuong Join
//     * + fetch Lazy: luoi - cham : Khi nao dung thi moi lay. Ban dau chua dung => null
//     * + fetch Eager: lay tat ca: Khong dung cung lay => Du lieu lon => Ton tai nguyen
//     * Default Many To One: Fetch Eager
//     */
//    @ManyToOne
//    @JoinColumn(name = "category_id", referencedColumnName = "id")
//    private Category1 cate;
//
//}
