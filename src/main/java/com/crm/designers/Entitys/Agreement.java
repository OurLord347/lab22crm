package com.crm.designers.Entitys;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
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

    private Integer number;
    private Date dateConclusion;

    @ManyToOne
    @JoinColumn(name="user_info_id")
    @JsonIgnore
    private UserInfo userInfo;

    @OneToMany(mappedBy = "agreement", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Invoice> invoices;

    @ManyToOne
    @JoinColumn(name="partner_type_id")
    @JsonIgnoreProperties("agreement")
    private PartnerType partnerType;

    @ManyToMany
    private List<ProductType> productTypes;

    @CreationTimestamp
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Agreement() {

    }
}
