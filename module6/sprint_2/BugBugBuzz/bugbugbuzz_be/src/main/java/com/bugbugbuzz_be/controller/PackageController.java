package com.bugbugbuzz_be.controller;

import com.bugbugbuzz_be.model.product.Package;
import com.bugbugbuzz_be.service.product.IPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/packages/")
@RequiredArgsConstructor
public class PackageController {
    private final IPackageService packageService;

    @GetMapping("/list")
    public ResponseEntity<List<Package>> getAllPackage() {
        List<Package> packages =packageService.getAllPackage();
        if(packages.size()!=0) {
            return ResponseEntity.ok(packages);
        }
        return ResponseEntity.noContent().build();
    }


}
