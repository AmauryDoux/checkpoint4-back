package com.sabso.advertisement.Services;

import com.sabso.advertisement.Entities.Screen;
import com.sabso.advertisement.Repositories.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScreenService {
    @Autowired
    ScreenRepository repository;

    public List<Screen> getScreens(){
        return repository.findAll();
    }

    public Screen save(Screen screen) {
        return repository.save(screen);
    }

    public Screen updateScreen(Screen newScreen, Long id) {
        return repository.findById(id)
                .map(screen -> {
                    screen.setUsed(newScreen.getUsed());
                    screen.setHasAds(newScreen.getHasAds());
                    screen.setAddress(newScreen.getAddress());
                    return repository.save(screen);
                })
                .orElseGet(() -> {
                    newScreen.setId(id);
                    return repository.save(newScreen);
                });
    }

    public void deleteById(Long id) {
        Optional<Screen> addToDelete = repository.findById(id);
        if (addToDelete.get().getId() != null){
            repository.deleteById(id);
        }
    }
}
