package com.crm.designers.Services;

import com.crm.designers.Entitys.ContactLink;
import com.crm.designers.Entitys.UserInfo;
import com.crm.designers.Repository.ContactLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ContactLinksService {
    @Autowired
    private ContactLinkRepository contactLinkRepository;

    public void updateContactLink(List<String> links, UserInfo userInfo) {
        List<ContactLink> contactLinks = userInfo.getContactLinks();
        contactLinks.forEach(ulink ->{
            if(!links.contains(ulink.getLink())){
                removeContactLink(ulink);
            }
        });
        for (String link : links) {
            if (!contactLinks.stream().anyMatch(l -> l.getLink().equals(link))) {
                createContactLink(link, userInfo);
            }
        }
    }
    public void removeContactLink(ContactLink contactLink) {
        contactLinkRepository.deleteById(contactLink.getId());
    }
    public void createContactLink(List<String> links, UserInfo userInfo) {
        links.forEach(link -> createContactLink(link, userInfo));
    }

    public ContactLink createContactLink(String link, UserInfo userInfo) {
        ContactLink contactLink = ContactLink.builder()
                .link(link)
                .userInfo(userInfo)
                .build();
        return contactLinkRepository.save(contactLink);
    }
}
