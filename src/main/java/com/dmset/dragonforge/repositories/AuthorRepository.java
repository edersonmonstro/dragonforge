package com.dmset.dragonforge.repositories;

import com.dmset.dragonforge.models.AuthorModel;
import com.dmset.dragonforge.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<AuthorModel, UUID> {
}
