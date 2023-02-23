package com.ngc.tas.extservices.mssql.web.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ngc.tas.extservices.mssql.domain.SamsSupplier;
import com.ngc.tas.extservices.mssql.repository.SamsSupplierRepository;
import com.ngc.tas.extservices.mssql.service.SamsSupplierService;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.SamsSupplier}.
 *
 * @author kwhittington
 */
@RestController
@RequestMapping("/api")
public class SamsSupplierResource {

    private final Logger log = LoggerFactory.getLogger(SamsSupplierResource.class);

    private final SamsSupplierService samsSupplierService;

    public SamsSupplierResource(SamsSupplierService samsSupplierService, SamsSupplierRepository samsSupplierRepository) {
        this.samsSupplierService = samsSupplierService;
    }

    /**
     * {@code GET  /sams-suppliers} : get all the samsSuppliers.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of samsSuppliers in body.
     */
    @GetMapping("/sams-supplier")
    public List<SamsSupplier> getAllSamsSuppliers() {
        log.debug("REST request to get all SamsSuppliers");
        return samsSupplierService.getAllSuppliers();
    }

    /**
     * {@code GET  /sams-suppliers/:supplierId} : get the "supplierId" samsSupplier.
     *
     * @param supplierId the id of the samsSupplier to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the samsSupplier, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/sams-supplier/{supplierId}")
    public SamsSupplier getSamsSupplier(@PathVariable String supplierId) {
        log.debug("REST request to get SamsSupplier : {}", supplierId);
        return samsSupplierService.getSupplierById(supplierId);
    }

    // creating a delete mapping that deletes a specific supplier
    @DeleteMapping("/sams-supplier/{id}")
    private void deleteStudent(@PathVariable("id") String id) {
        samsSupplierService.delete(id);
    }

    // creating post mapping that post the supplier detail in the database
    @PostMapping("/sams-supplier")
    private String saveStudent(@RequestBody SamsSupplier supplier) {
        samsSupplierService.saveOrUpdate(supplier);
        return supplier.getSupplierId();
    }
}
