package com.poc.watchlistservice.repository;

import com.poc.watchlistservice.entity.WatchlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchRepository extends JpaRepository<WatchlistEntity, Long> {
}
