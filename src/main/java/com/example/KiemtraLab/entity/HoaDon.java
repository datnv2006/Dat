package com.example.KiemtraLab.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHoaDon")
    private Integer id;
    @Column(name = "maHoaDon")
    private String maHd;
    @Column(name = "tongTienHang")
    private float tongTienHang;
    @Column(name = "tienThua")
    private float tienThua;
    @Column(name = "ghiChu")
    private String ghiChu;
    @Column(name = "maGiaoDich")
    private String maGiaoDich;
    @ManyToOne
    @JoinColumn(name = "idKhachHang")
    private KhachHang kh;
}
