package com.example.tenis.repositories;

import com.example.tenis.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    // Custom database queries if needed
}
