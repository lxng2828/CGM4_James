package com.example.app.Controller;

import com.example.app.model.Phone;
import com.example.app.service.PhoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phones")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class PhoneController {

    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping
    public ResponseEntity<List<Phone>> getAllPhones() {
        List<Phone> phones = phoneService.getAllPhones();
        return new ResponseEntity<>(phones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Phone> getPhoneById(@PathVariable Long id) {
        return phoneService.getPhoneById(id)
                .map(phone -> new ResponseEntity<>(phone, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Phone> createPhone(@RequestBody Phone phone) {
        Phone savedPhone = phoneService.savePhone(phone);
        return new ResponseEntity<>(savedPhone, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Phone> updatePhone(@PathVariable Long id, @RequestBody Phone phone) {

        if (!phoneService.getPhoneById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        phone.setId(id);
        Phone updatedPhone = phoneService.savePhone(phone);
        return new ResponseEntity<>(updatedPhone, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhone(@PathVariable Long id) {
        if (!phoneService.getPhoneById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        phoneService.deletePhone(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}