package ru.xpendence.persons.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 20.11.19
 * Time: 13:11
 * e-mail: v.chernyshov@pflb.ru
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role extends AbstractEntity {

    @Column(name = "role")
    private String role;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}
    )
    private List<User> users;

    public Role(String role) {
        this.role = role;
    }

    public Role(Long id, String role, List<User> users) {
        super(id);
        this.role = role;
        this.users = users;
    }
}
