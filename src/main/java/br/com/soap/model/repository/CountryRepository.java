package br.com.soap.model.repository;

import br.com.soap.model.Country;
import org.springframework.stereotype.Repository;

import java.text.NumberFormat;
import java.util.*;

@Repository
public class CountryRepository {

	private static final Map<String, Country> COUNTRIES = new HashMap<>();

	static {
		final Locale canada = Locale.CANADA;
		final Currency canadaCurrency = NumberFormat.getCurrencyInstance(canada).getCurrency();
		COUNTRIES.put(canada.getCountry(), new Country(canada.getCountry(), canada.getDisplayName(), canadaCurrency.getCurrencyCode()));

		final Locale us = Locale.US;
		final Currency usCurrency = NumberFormat.getCurrencyInstance(us).getCurrency();
		COUNTRIES.put(us.getCountry(), new Country(us.getCountry(), us.getDisplayName(), usCurrency.getCurrencyCode()));

		final Locale france = Locale.FRANCE;
		final Currency franceCurrency = NumberFormat.getCurrencyInstance(france).getCurrency();
		COUNTRIES.put(france.getCountry(), new Country(france.getCountry(), france.getDisplayName(), franceCurrency.getCurrencyCode()));

		final Locale german = Locale.GERMANY;
		final Currency germanCurrency = NumberFormat.getCurrencyInstance(german).getCurrency();
		COUNTRIES.put(german.getCountry(), new Country(german.getCountry(), german.getDisplayName(), germanCurrency.getCurrencyCode()));

		final Locale italy = Locale.ITALY;
		final Currency italyCurrency = NumberFormat.getCurrencyInstance(italy).getCurrency();
		COUNTRIES.put(italy.getCountry(), new Country(italy.getCountry(), italy.getDisplayName(), italyCurrency.getCurrencyCode()));
	}

	public List<Country> findAll() {
		return new ArrayList<>(COUNTRIES.values());
	}

	public Country findByCode(final String code) {
		return COUNTRIES.get(code);
	}

}
