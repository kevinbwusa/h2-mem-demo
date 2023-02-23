package com.ngc.tas.extservices.mssql.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ngc.tas.extservices.mssql.domain.SamsSupplier;
import com.ngc.tas.extservices.mssql.repository.SamsSupplierRepository;

/**
 * Service Implementation for managing {@link SamsSupplier}.
 *
 * @author kwhittington
 */
@Service
// @Transactional
public class SamsSupplierService {

    private final Logger log = LoggerFactory.getLogger(SamsSupplierService.class);

    private final SamsSupplierRepository samsSupplierRepository;

    public SamsSupplierService(SamsSupplierRepository samsSupplierRepository) {
        this.samsSupplierRepository = samsSupplierRepository;
    }

    /**
     * Get all the samsSuppliers.
     *samsSupplierRepository
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<SamsSupplier> getAllSuppliers() {
        log.debug("Request to get all SamsSuppliers");
        List<SamsSupplier> suppliers = new ArrayList<>();
        samsSupplierRepository.findAll().forEach(supplier -> suppliers.add(supplier));
        return suppliers;
    }

    /**
     * Get one samsSupplier by supplier id.
     *
     * @param supplierId the supplier id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public SamsSupplier getSupplierById(String supplierId) {
        log.debug("Request to get SamsSupplier : {}", supplierId);
        return samsSupplierRepository.findById(supplierId).get();
    }

    /**
     * Save or update existing supplier
     * @param supplierId
     */
    public void saveOrUpdate(SamsSupplier supplier) {
        samsSupplierRepository.save(supplier);
    }

    /**
     * Delete the samsSupplier by supplier id.
     *
     * @param supplierId the supplier id of the entity.
     */
    public void delete(String supplierId) {
        log.debug("Request to delete SamsSupplier : {}", supplierId);
        samsSupplierRepository.deleteById(supplierId);
    }
}
