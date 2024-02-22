package com.sthev.msemail.repositories;

import com.sthev.msemail.domain.Email;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, String> {

}
