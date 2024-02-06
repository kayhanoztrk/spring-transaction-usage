package com.example.transactionusage.repository;

import com.example.transactionusage.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public interface TagRepository extends JpaRepository<Tag, Long> {
}
