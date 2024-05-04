package com.crm.designers.Entitys;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@Entity(name="agreements")
public class Agreement {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String number;

    @ManyToOne
    @JoinColumn(name="user_info_id")
    @JsonIgnore
    private UserInfo userInfo;

    @OneToMany(mappedBy = "agreement", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("agreement")
    private List<Invoice> invoices;

    public Agreement() {

    }
}
