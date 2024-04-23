package com.hexagonal.infraestructure.entities;

import com.hexagonal.infraestructure.entities.enums.GenreInfraEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "author")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorEntity {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "author_registration")
    private String authorRegistration;

    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    private GenreInfraEnum genre;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
