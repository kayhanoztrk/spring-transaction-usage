package com.example.transactionusage.repository;

import com.example.transactionusage.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}
