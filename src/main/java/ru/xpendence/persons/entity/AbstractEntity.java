package ru.xpendence.persons.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 20.11.19
 * Time: 13:10
 * e-mail: v.chernyshov@pflb.ru
 */
@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created", updatable = false)
    private LocalDateTime created;

    @Column(name = "updated", insertable = false)
    private LocalDateTime updated;

    AbstractEntity(Long id) {
        this.id = id;
    }

    @PrePersist
    private void preCreate() {
        if (Objects.isNull(created)) {
            created = LocalDateTime.now();
        }
    }

    @PreUpdate
    private void preUpdate() {
        if (Objects.isNull(updated)) {
            updated = LocalDateTime.now();
        }
    }
}
