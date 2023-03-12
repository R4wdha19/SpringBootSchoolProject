package com.codeline.SpringBootPractice.School.project.Email.Repository;

import com.codeline.SpringBootPractice.School.project.Email.Model.EmailDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository {
    String sendSimpleMailToMany(EmailDetails emailDetails);
    String sendSimpleMail(EmailDetails emailDetails);
    String sendMailWithAttachmentToMany(EmailDetails emailDetails);
    String sendMailWithAttachment(EmailDetails emailDetails);
}


