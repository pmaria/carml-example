package com.skemu.rdf.rml;

import java.io.InputStream;
import java.util.Set;

import org.eclipse.rdf4j.model.Model;

import com.skemu.rdf.rml.function.Functions;
import com.taxonic.carml.engine.RmlMapper;
import com.taxonic.carml.logical_source_resolver.XPathResolver;
import com.taxonic.carml.model.TriplesMap;
import com.taxonic.carml.vocab.Rdf.Ql;

public class Mapper {

	private Set<TriplesMap> mapping;
	private RmlMapper rmlMapper;

	public Mapper(Set<TriplesMap> mapping) {
		this.mapping = mapping;
		this.rmlMapper = RmlMapper.newBuilder().setLogicalSourceResolver(Ql.XPath, new XPathResolver())
				.addFunctions(new Functions()).build();
	}

	public Model map(InputStream inputStream) {
		rmlMapper.bindInputStream(inputStream);
		return rmlMapper.map(mapping);
	}
}
