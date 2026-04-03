package com.example.KiemtraLab.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hoaDonChiTiet")
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHoaDonChiTiet")
    private Integer id;

    @Column(name = "soLuong")
    private Integer soLuong;

    @ManyToOne
    @JoinColumn(name = "idHoaDon")
    private HoaDon hoaDon;
}
