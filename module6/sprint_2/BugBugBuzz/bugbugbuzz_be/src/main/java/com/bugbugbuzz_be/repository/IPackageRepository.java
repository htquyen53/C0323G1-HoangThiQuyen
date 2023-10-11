package com.bugbugbuzz_be.repository;

import com.bugbugbuzz_be.model.product.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPackageRepository extends JpaRepository<Package, Long> {
}
