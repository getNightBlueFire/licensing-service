package com.optima.licensingservice.service;


import static com.optima.licensingservice.ConstantMessages.create;
import static com.optima.licensingservice.ConstantMessages.delete;
import static com.optima.licensingservice.ConstantMessages.update;

import com.optima.licensingservice.model.License;
import com.optima.licensingservice.repository.LicenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;

import java.util.Locale;
import java.util.Optional;
import java.util.Random;

@AllArgsConstructor
public class LicenseServiceImpl implements LicenseService {
    private final int random = 1000;

    private final MessageSource messageSource;
    private final LicenseRepository licenseRepository;

    @Override
    public License getLicense(final String licenseId, final String organizationId) {
        Optional<License> byId = licenseRepository.findById(licenseId);
        System.out.println(byId.orElse(null));
        License license = new License();
        license.setId(new Random().nextInt(random));
        license.setLicenseId(licenseId);
        license.setOrganizationId(organizationId);
        license.setDescription("Software product");
        license.setProductName("O-stock");
        license.setLicenseType("full");


        return license;
    }

    @Override
    public String createLicense(License license, String organizationId, Locale locale) {
        String response = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            response = String.format(messageSource.getMessage(create, null, locale), license);
        }
        return response;
    }

    @Override
    public String updateLicense(final License license, final String organizationId) {
        String response = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            response = String.format(messageSource.getMessage(update, null, null), license);
        }
        return response;
    }

    @Override
    public String deleteLicense(String licenseId, String organizationId) {
        return String.format(messageSource.getMessage(delete, null, null), licenseId, organizationId);
    }

}
