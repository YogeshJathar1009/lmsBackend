package com.example.springboot.lms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.lms.exception.ResourceNotFoundException;
import com.example.springboot.lms.model.Module;
import com.example.springboot.lms.repository.ModuleRepository;
@Service
public class ModuleServiceImpl implements ModuleService{
	private ModuleRepository moduleRepository;
	
	
	
	@Autowired
	public ModuleServiceImpl(ModuleRepository moduleRepository) {
		super();
		this.moduleRepository = moduleRepository;
	}
	
	public ModuleServiceImpl() {
		super();
	}



	@Override
	public Module saveModule(Module module) {
		
		return moduleRepository.save(module);
	}

	@Override
	public List<Module> getAllModules() {
		// TODO Auto-generated method stub
		return moduleRepository.findAll();
	}

	@Override
	public Module getModuleById(int moduleId) {
		// TODO Auto-generated method stub
		return moduleRepository.findById(moduleId).orElseThrow(() -> new ResourceNotFoundException("Module", "ID", moduleId));
	}

	@Override
	public Module updateModule(Module module, int moduleId) {
		Module existingModule = moduleRepository.findById(moduleId).orElseThrow(() -> new ResourceNotFoundException("Module", "ID", moduleId));

		existingModule.setModuleName(module.getModuleName());
		
		return existingModule;
	}

	@Override
	public void deleteModule(int moduleId) {
		// TODO Auto-generated method stub
		 moduleRepository.findById(moduleId).orElseThrow(() -> new ResourceNotFoundException("Module", "ID", moduleId));
		 moduleRepository.deleteById(moduleId);
	}

}
