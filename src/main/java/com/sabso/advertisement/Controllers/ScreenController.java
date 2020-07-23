package com.sabso.advertisement.Controllers;

import com.sabso.advertisement.Entities.Screen;
import com.sabso.advertisement.Services.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screens")
public class ScreenController {
    @Autowired
    ScreenService service;

    @GetMapping("/")
    public List<Screen> getScreens() {
        return service.getScreens();
    }

    @PostMapping("/")
    public void postScreen(@RequestBody Screen screen) {
        service.save(screen);
    }

    @PutMapping("/{id}")
    public Screen updateScreen(@RequestBody Screen newScreen, @PathVariable Long id) {
        return service.updateScreen(newScreen, id);
    }

    @DeleteMapping("/{id}")
    public void deleteScreen(@PathVariable Long id)
    {
        service.deleteById(id);
    }
}
