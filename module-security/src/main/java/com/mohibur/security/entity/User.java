package com.mohibur.security.entity;

import com.mohibur.common.entity.BaseModel;
import lombok.*;

import javax.persistence.*;
import java.util.List;

//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User extends BaseModel {
    @Id
    private String username;
    private String password;
    private Integer starCount;
    private boolean verified;
    private String verificationToken;

    @Column(unique = true, nullable = false)
    private String email;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ToString.Exclude
    private List<Role> roleList;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//        User user = (User) o;
//        return username != null && Objects.equals(username, user.username);
//    }
//
//    @Override
//    public int hashCode() {
//        return getClass().hashCode();
//    }

}
