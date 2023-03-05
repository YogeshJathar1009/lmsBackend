package com.example.springboot.lms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.lms.exception.ResourceNotFoundException;
import com.example.springboot.lms.model.Batch;
import com.example.springboot.lms.repository.BatchRepository;
@Service
public class BatchServiceImpl implements BatchServices{
	private BatchRepository batchRepository;
	
	
	

	public BatchServiceImpl() {
		super();
	}
	  @Autowired 
	public BatchServiceImpl(BatchRepository batchRepository) {
		super();
		this.batchRepository = batchRepository;
	}

	@Override
	public Batch saveBatch(Batch batch) {
	
		return batchRepository.save(batch);
	}

	@Override
	public List<Batch> getAllBatches() {
		// TODO Auto-generated method stub
		return batchRepository.findAll();
	}

	@Override
	public Batch getBatchById(int batchId) {
		// TODO Auto-generated method stub
		return batchRepository.findById(batchId).orElseThrow(() -> new ResourceNotFoundException("Batch", "ID", batchId));
	}

	@Override
	public Batch updateBatch(Batch batch, int batchId) {
	Batch existingBatch =batchRepository.findById(batchId).orElseThrow(() -> new ResourceNotFoundException("Batch", "ID", batchId));
		
	
	
	return existingBatch;
	}

	@Override
	public void deleteBatch(int batchId) {
		
		batchRepository.findById(batchId).orElseThrow(() -> new ResourceNotFoundException("Batch", "ID", batchId));
		batchRepository.deleteById(batchId);
	}

}
