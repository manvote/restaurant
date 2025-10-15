package com.example.StaffManagement.Service;

import com.example.StaffManagement.Repository.Staff;
import com.example.StaffManagement.Repository.StaffRepository;
import com.example.StaffManagement.Repository.UserAuthentication;
import com.example.StaffManagement.Repository.UserAuthenticationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    private final StaffRepository staffRepository;
    private final UserAuthenticationRepository userAuthRepository;

    public StaffService(StaffRepository staffRepository, UserAuthenticationRepository userAuthRepository) {
        this.staffRepository = staffRepository;
        this.userAuthRepository = userAuthRepository;
    }

    public Staff addStaff(Staff staff) {
        // Save staff first
        Staff savedStaff = staffRepository.save(staff);

        // Save in UserAuthentication table
        UserAuthentication auth = new UserAuthentication();
        auth.setStaff(savedStaff);
        auth.setUsername(staff.getUsername());
        auth.setPassword(staff.getPassword()); // hash if needed
        userAuthRepository.save(auth);

        return savedStaff;
    }

    public Staff login(String username, String password) {
        UserAuthentication auth = userAuthRepository.findAll()
                .stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        return auth.getStaff();
    }


    public List<Staff> getAllStaff() { return staffRepository.findAll(); }

    public Optional<Staff> getStaff(Long id) { return staffRepository.findById(id); }

    // Delete Staff
    public void deleteStaff(Long id) { staffRepository.deleteById(id); }
}
