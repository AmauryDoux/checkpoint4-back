package com.sabso.advertisement.Services;

import com.sabso.advertisement.Entities.Advert;
import com.sabso.advertisement.Repositories.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdvertService {
    @Autowired
    AdvertRepository repository;

    public List<Advert> getAdverts(){
        return repository.findAll();
    }

    public Advert save(Advert advert) {
        return repository.save(advert);
    }

    public Advert updateAdvert(Advert newAdvert, Long id) {
        return repository.findById(id)
                .map(advert -> {
                    advert.setName(newAdvert.getName());
                    return repository.save(advert);
                })
                .orElseGet(() -> {
                    newAdvert.setId(id);
                    return repository.save(newAdvert);
                });
    }

    public void deleteById(Long id) {
        Optional<Advert> addToDelete = repository.findById(id);
        if (addToDelete.get().getId() != null){
            repository.deleteById(id);
        }
    }

}

