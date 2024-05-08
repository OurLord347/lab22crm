package com.crm.designers.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@Entity(name = "partner_types")
public class PartnerType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name; // название типа сотрудничества

    @OneToMany(mappedBy="partnerType", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("partnerType")
    private List<Agreement> agreements;

    @CreationTimestamp
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PartnerType() {

    }
}
