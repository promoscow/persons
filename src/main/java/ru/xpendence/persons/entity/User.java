package ru.xpendence.persons.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 20.11.19
 * Time: 13:10
 * e-mail: v.chernyshov@pflb.ru
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private List<Role> roles;

    public User(String name,
                String surname,
                String patronymic,
                String email,
                String phone,
                List<Role> roles) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.email = email;
        this.phone = phone;
        this.roles = roles;
    }

    public User(Long id,
                String name,
                String surname,
                String patronymic,
                String email,
                String phone,
                List<Role> roles) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.email = email;
        this.phone = phone;
        this.roles = roles;
    }
}
