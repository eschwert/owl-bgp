package org.semanticweb.sparql.owlbgpparser.triplehandlers.rdftype;

import org.semanticweb.sparql.owlbgp.model.Identifier;
import org.semanticweb.sparql.owlbgpparser.TripleConsumer;
import org.semanticweb.sparql.owlbgpparser.Vocabulary;

public class TypeOntologyHandler extends BuiltInTypeHandler {

    public TypeOntologyHandler(TripleConsumer consumer) {
        super(consumer, Vocabulary.OWL_ONTOLOGY.getIRI());
    }

    public void handleTriple(Identifier subject, Identifier predicate, Identifier object) {
        consumer.addOntologyIRI(subject);
        consumer.consumeTriple(subject, predicate, object);
    }
}
