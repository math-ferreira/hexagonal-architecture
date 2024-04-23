package com.hexagonal.infraestructure.entities;

import com.hexagonal.infraestructure.entities.enums.CurrencyInfraEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "book")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "title")
    private String title;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private AuthorEntity author;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @Column(name = "price")
    private double price;

    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    private CurrencyInfraEnum currency;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
