package com.example.springboot.lms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.lms.exception.ResourceNotFoundException;
//import com.example.springboot.lms.model.Module;
import com.example.springboot.lms.model.PDF;
import com.example.springboot.lms.repository.PDFRepository;

//import jakarta.persistence.ManyToOne;
@Service
public class PDFServiceImpl implements PDFService{
	private PDFRepository pdfRepository;
	
	
	
	public PDFServiceImpl() {
		super();
	}
	  @Autowired 
	public PDFServiceImpl(PDFRepository pdfRepository) {
		super();
		this.pdfRepository = pdfRepository;
	}

	
	
	
	
	
	@Override
	public PDF savePDF(PDF pdf) {
		// TODO Auto-generated method stub
		return pdfRepository.saveAndFlush(pdf);
	}

	@Override
	public List<PDF> getAllPDFs() {
		// TODO Auto-generated method stub
		return pdfRepository.findAll();
	}

	@Override
	public PDF getPDFById(int pdfId) {
		// TODO Auto-generated method stub
		return pdfRepository.findById(pdfId).orElseThrow(() -> new ResourceNotFoundException("PDF", "ID", pdfId));
	}

	@Override
	public PDF updatePDF(PDF pdf, int pdfId) {
		PDF existingPDF =pdfRepository.findById(pdfId).orElseThrow(() -> new ResourceNotFoundException("PDF", "ID", pdfId));
		
		existingPDF.setModule(pdf.getModule());
		existingPDF.setName(pdf.getName());
		existingPDF.setPath(pdf.getPath());
		
		return existingPDF;
	}

	@Override
	public void deletePDF(int pdfId) {
		 pdfRepository.findById(pdfId).orElseThrow(() -> new ResourceNotFoundException("PDF", "ID", pdfId));
		pdfRepository.deleteById(pdfId);
	}

}
