package com.sabso.advertisement.Repositories;

import com.sabso.advertisement.Entities.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository extends JpaRepository<Screen,Long> {
}