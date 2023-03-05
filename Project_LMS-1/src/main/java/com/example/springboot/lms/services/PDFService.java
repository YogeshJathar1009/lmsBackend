package com.example.springboot.lms.services;

import java.util.List;

import com.example.springboot.lms.model.PDF;

public interface PDFService {
	PDF savePDF(PDF pdf);
	List<PDF> getAllPDFs();
	PDF getPDFById(int pdfId);
	PDF updatePDF(PDF pdf,int pdfId);
     void deletePDF(int pdfId);
}
