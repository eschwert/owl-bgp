package org.semanticweb.sparql.owlbgp.model;

public interface ExtendedOWLObjectVisitorEx<O> {
    O visit(Clazz clazz);
    O visit(ClassVariable classVariable);
    O visit(ObjectIntersectionOf objectIntersectionOf);
    O visit(ObjectUnionOf objectUnionOf);
    O visit(ObjectComplementOf objectComplementOf);
    O visit(ObjectSomeValuesFrom objectSomeValuesFrom);
    O visit(ObjectAllValuesFrom objectAllValuesFrom);
    O visit(ObjectHasValue objectHasValue);
    O visit(ObjectMinCardinality objectMinCardinality);
    O visit(ObjectExactCardinality objectExactCardinality);
    O visit(ObjectMaxCardinality objectMaxCardinality);
    O visit(ObjectHasSelf objectHasSelf);
    O visit(ObjectOneOf objectOneOf);
    O visit(DataSomeValuesFrom dataSomeValuesFrom);
    O visit(DataAllValuesFrom dataAllValuesFrom);
    O visit(DataHasValue dataHasValue);
    O visit(DataMinCardinality dataMinCardinality );
    O visit(DataExactCardinality dataExactCardinality);
    O visit(DataMaxCardinality dataMaxCardinality);
    
    O visit(ObjectProperty objectProperty);
    O visit(InverseObjectProperty inverseObjectProperty);
    O visit(ObjectPropertyVariable objectPropertyVariable);
    O visit(DataProperty dataProperty);
    O visit(DataPropertyVariable dataPropertyVariable);
    
    O visit(Literal literal);
    O visit(LiteralVariable literalVariable);
    
    O visit(NamedIndividual namedIndividual);
    O visit(AnonymousIndividual anonymousIndividual);
    O visit(IndividualVariable individualVariable);
    
    O visit(Datatype datatype);
    O visit(DatatypeVariable datatypeVariable);
    O visit(DatatypeRestriction datatypeRestriction);
    O visit(FacetRestriction facetRestriction);
    O visit(DataComplementOf dataComplementOf);
    O visit(DataIntersectionOf dataIntersectionOf);
    O visit(DataUnionOf dataUnionOf);
    O visit(DataOneOf dataOneOf);
}