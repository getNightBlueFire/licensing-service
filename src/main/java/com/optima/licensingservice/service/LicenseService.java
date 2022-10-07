package com.optima.licensingservice.service;

import com.optima.licensingservice.model.License;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public interface LicenseService {
    License getLicense(String licenseId, String organizationId);

    String createLicense(License license, String organizationId, Locale locale);

    String updateLicense(License license, String organizationId);

    String deleteLicense(String licenseId, String organizationId);
}
