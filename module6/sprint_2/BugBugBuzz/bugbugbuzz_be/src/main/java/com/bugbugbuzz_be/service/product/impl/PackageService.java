package com.bugbugbuzz_be.service.product.impl;

import com.bugbugbuzz_be.model.product.Package;
import com.bugbugbuzz_be.repository.product.IPackageRepository;
import com.bugbugbuzz_be.service.product.IPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PackageService implements IPackageService {
    private final IPackageRepository packageRepository;

    @Override
    public List<Package> getAllPackage() {
        return packageRepository.findAll();
    }

    @Override
    public Package findById(Long id) {
        return packageRepository.findById(id).orElse(null);
    }
}
