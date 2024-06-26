package com.dmset.dragonforge.repositories;

import com.dmset.dragonforge.models.BookModel;
import com.dmset.dragonforge.models.PublisherModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublisherRepository extends JpaRepository<PublisherModel, UUID> {
}
