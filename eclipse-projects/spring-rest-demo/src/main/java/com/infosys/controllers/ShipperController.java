package com.infosys.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.dao.ShipperDao;
import com.infosys.entity.Shipper;
import com.infosys.model.CustomResponse;
import com.infosys.model.ShipperList;

@RestController
@RequestMapping("/api/shippers")
public class ShipperController {

	@Autowired
	private ShipperDao dao;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> handlePost(@RequestBody Shipper shipper){
		try {
			shipper = dao.add(shipper);
			return ResponseEntity.ok(shipper);
		}
		catch(Exception e) {
			CustomResponse cr = new CustomResponse(e.getMessage());
			return ResponseEntity.status(500).body(cr);
		}
	}

	@GetMapping(produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<?> handleGetAllAsText() {
		List<String> list = dao.findAll().stream().map(Shipper::toString).collect(Collectors.toList());

		return ResponseEntity.ok(list.toString());
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> handleGetAllAsJsonAndXml() {
		List<Shipper> list = dao.findAll();
		ShipperList shipperList = new ShipperList(list);
		return ResponseEntity.ok(shipperList);
	}

	@GetMapping(path = "/{shipperId}", produces = { "application/json", "application/xml" })
	public ResponseEntity<?> handleGetOneAsJsonAndXml(@PathVariable Integer shipperId) {

		Shipper shipper = dao.findById(shipperId);
		if (shipper == null) {
			CustomResponse cr = new CustomResponse("No data found for shipper id " + shipperId);
			return ResponseEntity.status(404).body(cr);
		}

		return ResponseEntity.ok(shipper);
	}

	@GetMapping(path = "/{shipperId}", produces = "text/plain")
	public ResponseEntity<String> handleGetOneAsText(@PathVariable Integer shipperId) {
		Shipper shipper = dao.findById(shipperId);
		String resp;

		if (shipper == null) {
			resp = "No data found for shipper id " + shipperId;
			return ResponseEntity.status(404).body(resp);
		} else {
			resp = shipper.toString();
			return ResponseEntity.ok(resp);
		}
	}
}
