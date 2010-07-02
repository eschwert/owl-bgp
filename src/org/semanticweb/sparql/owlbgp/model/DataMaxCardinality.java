/* Copyright 2010 by the Oxford University Computing Laboratory
   
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
   along with OWL-BGP.  If not, see <http://www.gnu.org/licenses/>.
*/
package org.semanticweb.sparql.owlbgp.model;

import java.util.HashSet;
import java.util.Set;


public class DataMaxCardinality extends AbstractExtendedOWLObject implements ClassExpression {
    private static final long serialVersionUID = -2047206133526997652L;

    protected final int m_cardinality;
    protected final DataPropertyExpression m_dpe;
    protected final DataRange m_dataRange;
   
    protected DataMaxCardinality(int cardinality,DataPropertyExpression ope,DataRange dataRange) {
        m_cardinality=cardinality;
        m_dpe=ope;
        m_dataRange=dataRange;
    }
    public String toString(Prefixes prefixes) {
        StringBuffer buffer=new StringBuffer();
        buffer.append("DataMaxCardinality(");
        buffer.append(m_cardinality);
        buffer.append(" ");
        buffer.append(m_dpe.toString(prefixes));
        buffer.append(" ");
        buffer.append(m_dataRange.toString(prefixes));
        buffer.append(")");
        return buffer.toString();
    }
    protected Object readResolve() {
        return s_interningManager.intern(this);
    }
    protected static InterningManager<DataMaxCardinality> s_interningManager=new InterningManager<DataMaxCardinality>() {
        protected boolean equal(DataMaxCardinality object1,DataMaxCardinality object2) {
            return object1.m_cardinality==object2.m_cardinality && object1.m_dpe.equals(object2.m_dpe) && object1.m_dataRange.equals(object2.m_dataRange);
        }
        protected int getHashCode(DataMaxCardinality object) {
            return 23*object.m_cardinality+17*object.m_dpe.hashCode()+7*object.m_dataRange.hashCode();
        }
    };
    public static DataMaxCardinality create(int cardinality,DataPropertyExpression dpe,DataRange dataRange) {
        return s_interningManager.intern(new DataMaxCardinality(cardinality,dpe,dataRange));
    }
    public String getIdentifier() {
        return null;
    }
    public <O> O accept(ExtendedOWLObjectVisitorEx<O> visitor) {
        return visitor.visit(this);
    }
    public Set<Variable> getVariablesInSignature() {
        Set<Variable> variables=new HashSet<Variable>();
        variables.addAll(m_dpe.getVariablesInSignature());
        variables.addAll(m_dataRange.getVariablesInSignature());
        return variables;
    }
}
