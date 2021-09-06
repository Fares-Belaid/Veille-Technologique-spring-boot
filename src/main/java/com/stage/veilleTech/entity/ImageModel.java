//package com.stage.veilleTech.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "image_table")
//@AllArgsConstructor
//@Data
//public class ImageModel {
//
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//
//    private String type;
//
//    @Column(name = "picByte", length = 1000)
//    private byte[] picByte;
//
//    @OneToOne
//    @JoinColumn(name = "formation_id")
//    private Formation formation;
//
//
//    public ImageModel() {
//        super();
//    }
//
//    public ImageModel(String name, String type, byte[] picByte) {
//        this.name = name;
//        this.type = type;
//        this.picByte = picByte;
//    }
//}
