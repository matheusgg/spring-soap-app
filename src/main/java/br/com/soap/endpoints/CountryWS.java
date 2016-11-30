package br.com.soap.endpoints;

import br.com.soap.model.*;
import br.com.soap.model.repository.CountryRepository;
import br.com.soap.util.SOAPConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryWS {

	private CountryRepository countryRepository;

	@Autowired
	public CountryWS(final CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@PayloadRoot(namespace = SOAPConstants.NAMESPACE, localPart = "getAllCountriesRequest")
	@ResponsePayload
	public GetAllCountriesResponse getAllCountries(@RequestPayload final GetAllCountriesRequest request) {
		return new GetAllCountriesResponse(this.countryRepository.findAll());
	}

	@PayloadRoot(namespace = SOAPConstants.NAMESPACE, localPart = "getCountryByCodeRequest")
	@ResponsePayload
	public GetCountryByCodeResponse getCountryByCode(@RequestPayload final GetCountryByCodeRequest request) {
		return new GetCountryByCodeResponse(this.countryRepository.findByCode(request.getCode()));
	}

}
