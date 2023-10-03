package com.Assignment.Livesy.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.Assignment.Livesy.entities.Load;

public interface LoadService {
	public String addLoad(Load load);
	public List<Load> getLoadsByShipperId(String shipperId);
	public Optional<Load> getLoadById(UUID loadId) ;
	public String updateLoad(UUID loadId, Load updatedLoad);
	 public String deleteLoad(UUID loadId);
}
