package com.example.springboot.lms.services;

import java.util.List;

import com.example.springboot.lms.model.Batch;

public interface BatchServices {
	
	Batch saveBatch(Batch batch);
	List<Batch> getAllBatches();
	Batch getBatchById(int batchId);
	Batch updateBatch(Batch batch,int batchId);
     void deleteBatch(int batchId);
	
	
}
