package com.example.cryptoautomation.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "report_histories")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReportHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String market;

    @Column
    private String price;

    @Column(name = "reported_at")
    private LocalDateTime reportedAt;

    public ReportHistory(String market, String price) {
        this.market = market;
        this.price = price;
        this.reportedAt = LocalDateTime.now();
    }
}
