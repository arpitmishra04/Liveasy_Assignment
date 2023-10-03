package com.Assignment.Livesy.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Assignment.Livesy.dao.LoadRepository;
import com.Assignment.Livesy.entities.Load;
@Service
public class LoadServiceImpl implements LoadService {
	
	private final Map<UUID, Load> loads = new ConcurrentHashMap<>();
	private final LoadRepository repository;
	
	 @Autowired
	    public LoadServiceImpl(LoadRepository repository) {
	        this.repository = repository;
	    }

	@Override
	public String addLoad(Load load) {
		// TODO Auto-generated method stub
		 UUID loadId = UUID.randomUUID();
	        load.setId(loadId);
	        repository.save(load);
		return "Load details added successfully";
	}	

	@Override
	public List<Load> getLoadsByShipperId(String shipperId) {
		// TODO Auto-generated method stub
		return repository.findByShipperId(shipperId);
		
	}

	@Override
	public Optional<Load> getLoadById(UUID loadId) {
		// TODO Auto-generated method stub
		 return repository.findById(loadId);
	}

	@Override
	public String updateLoad(UUID loadId, Load updatedLoad) {
		// TODO Auto-generated method stub
		 Load load = repository.getById(loadId);
	        if (load != null) {
	            load.setLoadingPoint(updatedLoad.getLoadingPoint());
	            load.setUnloadingPoint(updatedLoad.getUnloadingPoint());
	            load.setProductType(updatedLoad.getProductType());
	            load.setTruckType(updatedLoad.getTruckType());
	            load.setNoOfTrucks(updatedLoad.getNoOfTrucks());
	            load.setWeight(updatedLoad.getWeight());
	            load.setComment(updatedLoad.getComment());
	            load.setDate(updatedLoad.getDate());
	            load.setShipperId(updatedLoad.getShipperId());
	            repository.save(load);
	            return "Load updated successfully";
	        } else {
	            return "Load not found";
	        }
	}

	@Override
	public String deleteLoad(UUID loadId) {
		// TODO Auto-generated method stub
		       repository.deleteById(loadId);
	            return "Load deleted successfully";
	        
	    }
	}


