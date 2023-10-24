package com.bugbugbuzz_be.controller;

import com.bugbugbuzz_be.model.product.Package;
import com.bugbugbuzz_be.service.product.IPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/packages/")
@RequiredArgsConstructor
public class PackageController {
    private final IPackageService packageService;

    @GetMapping("/home/list")
    public ResponseEntity<List<Package>> getAllPackage() {
        List<Package> packages = packageService.getAllPackage();
        if (packages.size() != 0) {
            return ResponseEntity.ok(packages);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Package> getPackageById (@PathVariable Long id) {
        Package result = packageService.findById(id);
        if (result!=null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.noContent().build();
    }


}
