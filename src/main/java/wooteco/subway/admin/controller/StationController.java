package wooteco.subway.admin.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import wooteco.subway.admin.domain.Station;
import wooteco.subway.admin.dto.StationCreateRequest;
import wooteco.subway.admin.dto.StationResponse;
import wooteco.subway.admin.service.StationService;

@RestController
public class StationController {
	private final StationService stationService;

	public StationController(final StationService stationService) {
		this.stationService = stationService;
	}

	@PostMapping("/stations")
	public ResponseEntity<Long> createStation(
		@RequestBody final StationCreateRequest view) {
		Station station = view.toStation();
		Station persistStation = stationService.save(station);

		return ResponseEntity
			.created(URI.create("/stations/" + persistStation.getId()))
			.body(persistStation.getId());
	}

	@GetMapping("/stations")
	public ResponseEntity<List<StationResponse>> showStations() {
		return ResponseEntity.ok().body(stationService.findAll());
	}

	@DeleteMapping("/stations/{id}")
	public ResponseEntity<Void> deleteStation(@PathVariable final Long id) {
		stationService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
