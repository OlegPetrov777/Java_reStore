package com.example.reStore.repository;

import com.example.reStore.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository  extends JpaRepository<UserProfile, Long> {
}
