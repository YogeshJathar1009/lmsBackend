package com.example.springboot.lms.services;

import java.util.List;

import com.example.springboot.lms.model.Module;

public interface ModuleService {

	Module saveModule(Module module);
	List<Module> getAllModules();
	Module getModuleById(int moduleId);
	Module updateModule(Module module,int moduleId);
     void deleteModule(int moduleId);
}
