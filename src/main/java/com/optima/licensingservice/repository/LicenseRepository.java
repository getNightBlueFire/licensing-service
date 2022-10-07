package com.optima.licensingservice.repository;

import com.optima.licensingservice.model.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LicenseRepository extends CrudRepository<License, String> {
    Optional<License> findLicenseByLicenseId(String licenseId);

    Optional<License> findByProductNameContainsIgnoreCase(String productName);

    List<License> findByOrganizationId(String organizationId);

    License findByOrganizationIdAndLicenseId(String organizationId, String licenseId);
}
