package org.ey.dao;
import org.ey.dto.Train;
import org.ey.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TrainDao {
	@Autowired
	TrainRepository repository;

	public Train save(Train train) {
		return repository.save(train);
	}

	}
