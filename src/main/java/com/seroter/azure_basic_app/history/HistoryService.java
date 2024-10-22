package com.seroter.azure_basic_app.history;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
	private final HistoryRepository historyRepository;

	@Autowired
	public HistoryService(HistoryRepository historyRepository) {
		this.historyRepository = historyRepository;
	}

	public List<History> getHistory() {
		return historyRepository.findAll();
	}

	public Optional<History> getById(Long id) {
		return historyRepository.findById(id);

	}

	public List<History> getHistories(Long userId) {
		return historyRepository.findByMembers(userId);
	}

	public void addNewHistory(History newHistory) {
		historyRepository.save(newHistory);
	}
}
