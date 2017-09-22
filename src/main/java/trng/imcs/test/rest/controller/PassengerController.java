package trng.imcs.test.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import trng.imcs.test.model.Passenger;
import trng.imcs.test.service.PassengerService;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

	@Autowired
	private PassengerService passengerService;

	@RequestMapping(value = "/{profileId}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> getPassenger(@PathVariable int profileId) {
		Passenger passenger = passengerService.getPassenger(profileId);
		if (passenger == null) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(passenger, HttpStatus.ACCEPTED);
		}
	}

	
	@SuppressWarnings("unused")
	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_HTML_VALUE })
	public ResponseEntity<?> createPassenger(@RequestBody Passenger passenger) {
		Passenger emp = null;
		try {
			passenger = passengerService.addPassenger(passenger);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (emp != null) {
			return new ResponseEntity<>(emp, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(emp, HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/{profileId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePassenger(@PathVariable int profileId) {

		passengerService.deletePassenger(profileId);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> updatePassenger(@RequestBody Passenger passenger) {
		Passenger emp = passengerService.updatePassenger(passenger);
		if (emp == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

}
