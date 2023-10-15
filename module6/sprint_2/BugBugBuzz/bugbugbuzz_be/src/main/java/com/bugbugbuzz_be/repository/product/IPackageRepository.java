package com.bugbugbuzz_be.repository.product;

import com.bugbugbuzz_be.model.product.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPackageRepository extends JpaRepository<Package, Long> {
}
