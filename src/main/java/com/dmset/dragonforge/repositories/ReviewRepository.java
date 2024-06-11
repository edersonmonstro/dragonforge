package com.dmset.dragonforge.repositories;

import com.dmset.dragonforge.models.BookModel;
import com.dmset.dragonforge.models.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<ReviewModel, UUID> {
}
