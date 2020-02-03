package com.skemu.rdf.rml.function;

import com.taxonic.carml.engine.function.FnoFunction;
import com.taxonic.carml.engine.function.FnoParam;

public class Functions {

	private static final String EX = "http://example.com/ns#";

	@FnoFunction(EX + "multiplyWith")
	public static int multiplyWith(@FnoParam(EX + "multiplier") int multiplier, @FnoParam(EX + "input") int input) {
		return input * multiplier;
	}

}
