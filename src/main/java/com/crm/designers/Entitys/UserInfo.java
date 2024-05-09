package com.crm.designers.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@Entity(name = "users_info")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String surname; //Фамилия
    private String name; // Имя
    private String lastname; // Отчество
    private String phone; // телефон


    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToOne
    @JoinColumn(name="passport_id")
    private Passport passport;

    @OneToMany(mappedBy="userInfo", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("userInfo")
    private List<Agreement> agreements;

    @OneToMany(mappedBy="userInfo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("userInfo")
    private List<ContactLink> contactLinks;

    @OneToMany(mappedBy="userInfo", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("userInfo")
    private List<Brand> brands;

    @OneToMany(mappedBy="userInfo", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("userInfo")
    private List<Company> companies;

    @CreationTimestamp
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserInfo() {

    }
}
