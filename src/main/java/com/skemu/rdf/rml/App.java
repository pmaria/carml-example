package com.skemu.rdf.rml;

import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Set;

import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.Rio;

import com.taxonic.carml.model.TriplesMap;
import com.taxonic.carml.util.RmlMappingLoader;

public class App {

	public static void main(String... args) {

		// load mapping
		Set<TriplesMap> mapping = RmlMappingLoader.build().load(RDFFormat.TURTLE,
				App.class.getResourceAsStream("/mapping.rml.ttl"));

		// get source inputStream
		InputStream inputStream = App.class.getResourceAsStream("/input.xml");

		// Transform to RDF model
		Mapper mapper = new Mapper(mapping);
		Model model = mapper.map(inputStream);

		// Serialize to RDF
		Writer writer = new StringWriter();
		Rio.write(model, writer, RDFFormat.TURTLE);
		System.out.println(writer);
	}

}
