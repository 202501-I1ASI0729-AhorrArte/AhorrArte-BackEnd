package com.finsuma.ahorrarte.platform.userInflation.interfaces.rest;

import com.finsuma.ahorrarte.platform.userInflation.application.internal.commandservices.UserInflationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/{userId}/reports")
public class UserInflationController {

    @Autowired
    private UserInflationService service;

    @PostMapping("/{reportId}")
    public ResponseEntity<Void> assignReportToUser(
            @PathVariable Long userId, @PathVariable Long reportId) {
        service.assignReportToUser(userId, reportId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{reportId}")
    public ResponseEntity<Void> removeReportFromUser(
            @PathVariable Long userId, @PathVariable Long reportId) {
        service.removeReportFromUser(userId, reportId);
        return ResponseEntity.noContent().build();
    }
}
