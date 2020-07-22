package com.sabso.advertisement.Repositories;

import com.sabso.advertisement.Entities.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertRepository extends JpaRepository<Advert,Long> {
}
