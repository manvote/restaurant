package com.example.StaffManagement.Controller;

import com.example.StaffManagement.Repository.Staff;
import com.example.StaffManagement.Service.StaffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/staff")
public class StaffController {

    private final StaffService service;

    public StaffController(StaffService service) { this.service = service; }

    @PostMapping("/add")
    public Staff addOrUpdateStaff(@RequestBody Staff staff) {
        return service.addStaff(staff);
    }

    @PostMapping("/login")
    public Staff login(@RequestParam String username, @RequestParam String password) {
        return service.login(username, password);
    }

    @GetMapping("/list")
    public List<Staff> getAllStaff() { return service.getAllStaff(); }

    @GetMapping("/{id}")
    public Optional<Staff> getStaff(@PathVariable Long id) { return service.getStaff(id); }

    @DeleteMapping("/delete/{id}")
    public String deleteStaff(@PathVariable Long id) {
        service.deleteStaff(id);
        return "Staff deleted";
    }
}
