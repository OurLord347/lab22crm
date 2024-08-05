package com.crm.designers.Repository;

import com.crm.designers.Entitys.ContactLink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactLinkRepository extends JpaRepository<ContactLink, Long> {
    void deleteById(UUID uuid);
}
