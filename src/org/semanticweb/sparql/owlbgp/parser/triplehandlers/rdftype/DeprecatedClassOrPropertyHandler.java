/* Copyright 2011 by the Oxford University Computing Laboratory

   This file is part of OWL-BGP.

   OWL-BGP is free software: you can redistribute it and/or modify
   it under the terms of the GNU Lesser General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   OWL-BGP is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License
   along with OWL-BGP. If not, see <http://www.gnu.org/licenses/>.
 */

package  org.semanticweb.sparql.owlbgp.parser.triplehandlers.rdftype;

import java.util.Set;

import org.semanticweb.sparql.owlbgp.model.Annotation;
import org.semanticweb.sparql.owlbgp.model.AnnotationSubject;
import org.semanticweb.sparql.owlbgp.model.AnnotationValue;
import org.semanticweb.sparql.owlbgp.model.Identifier;
import org.semanticweb.sparql.owlbgp.model.axioms.AnnotationAssertion;
import org.semanticweb.sparql.owlbgp.model.dataranges.Datatype;
import org.semanticweb.sparql.owlbgp.model.literals.TypedLiteral;
import org.semanticweb.sparql.owlbgp.model.properties.AnnotationProperty;
import org.semanticweb.sparql.owlbgp.parser.TripleConsumer;
import org.semanticweb.sparql.owlbgp.parser.Vocabulary;
import org.semanticweb.sparql.owlbgp.parser.triplehandlers.TripleHandler;

public class DeprecatedClassOrPropertyHandler extends TripleHandler {

    public DeprecatedClassOrPropertyHandler(TripleConsumer consumer) {
        super(consumer);
    }

    @Override
    public void handleStreaming(Identifier subject, Identifier predicate, Identifier object) {
        super.handleStreaming(subject, predicate, object, false);
        if (consumer.isAnonymous(subject))
            throw new RuntimeException("Error: The subject of the triple "+subject+" "+predicate+" "+object+" is anonymous, but annotation assertions cannot have anonymous individuals as subjects. ");
    }
    @Override
    public void handleTriple(Identifier subject, Identifier predicate, Identifier object, Set<Annotation> annotations) {
        consumer.addAxiom(AnnotationAssertion.create(AnnotationProperty.create(Vocabulary.OWL_DEPRECATED), (AnnotationSubject)subject, (AnnotationValue)TypedLiteral.create("true", null, Datatype.XSD_BOOLEAN)));
    }
}
