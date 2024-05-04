package com.crm.designers.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.print.attribute.standard.MediaSize;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@Entity(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String fileName;

    @ManyToOne
    @JoinColumn(name="agreement_id")
    @JsonIgnore
    private Agreement agreement;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("invoice")
    private List<Product> products;

    public Invoice() {

    }
}
