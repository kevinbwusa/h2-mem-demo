package com.ngc.tas.extservices.mssql.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ngc.tas.extservices.mssql.domain.SamsSupplier;

/**
 * Spring Data JPA repository for the SamsSupplier entity.
 */
@Repository
public interface SamsSupplierRepository extends CrudRepository<SamsSupplier, String> {

    // @Override
    // @Query(value = "select * from [SAMS_2020andbeyond] where supplierId = :supplierId", nativeQuery = true)
    // Optional<SamsSupplier> findById(@Param("supplierId") String supplierId);

    // @Override
    // @Query(value = "select * from [SAMS_2020andbeyond]", nativeQuery = true)
    // List<SamsSupplier> findAll();
}
