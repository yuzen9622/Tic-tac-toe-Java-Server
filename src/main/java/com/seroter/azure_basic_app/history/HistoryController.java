package com.seroter.azure_basic_app.history;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/v1/history")
public class HistoryController {
	private final HistoryService historyService;

	@Autowired
	public HistoryController(HistoryService historyService) {
		this.historyService = historyService;
	}

	@GetMapping
	public List<History> getHistory() {
		return historyService.getHistory();
	}

	@GetMapping("/history")
	public Optional<History> getHistoryById(@RequestParam Long id) {
		return historyService.getById(id);
	}

	@GetMapping("/userHistory")
	public List<History> getUserHistory(@RequestParam Long userId) {
		return historyService.getHistories(userId);
	}

	@PostMapping("/addHistory")
	public void addHistory(@RequestBody History history) {
		historyService.addNewHistory(history);
	}
}
