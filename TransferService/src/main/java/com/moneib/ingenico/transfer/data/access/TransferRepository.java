package com.moneib.ingenico.transfer.data.access;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.moneib.ingenico.transfer.data.model.Transfer;

/**
 * The Interface TransferRepository provides CRUD capabilites for the Transfer
 * entity.
 */
@Repository
public interface TransferRepository extends CrudRepository<Transfer, Long> {

}
