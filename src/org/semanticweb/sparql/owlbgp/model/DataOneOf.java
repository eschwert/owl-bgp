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

public class DataOneOf extends AbstractExtendedOWLObject implements DataRange {
    private static final long serialVersionUID = 3341650510200806191L;

    protected final Set<ILiteral> m_enumeration;
    
    protected DataOneOf(Set<ILiteral> enumeration) {
        m_enumeration=enumeration;
    }
    public Set<ILiteral> getLiterals() {
        return m_enumeration;
    }
    public String toString(Prefixes prefixes) {
        StringBuffer buffer=new StringBuffer();
        buffer.append("DataOneOf(");
        boolean notFirst=false;
        for (ILiteral literal : m_enumeration) {
            if (notFirst)
                buffer.append(' ');
            else 
                notFirst=true;
            buffer.append(literal.toString(prefixes));
        }
        buffer.append(")");
        return buffer.toString();
    }
    protected Object readResolve() {
        return s_interningManager.intern(this);
    }
    protected static InterningManager<DataOneOf> s_interningManager=new InterningManager<DataOneOf>() {
        protected boolean equal(DataOneOf dataOneOf1,DataOneOf dataOneOf2) {
            if (dataOneOf1.m_enumeration.size()!=dataOneOf2.m_enumeration.size())
                return false;
            for (ILiteral literal : dataOneOf1.m_enumeration) {
                if (!contains(literal, dataOneOf2.m_enumeration))
                    return false;
            } 
            return true;
        }
        protected boolean contains(ILiteral literal ,Set<ILiteral> literals) {
            for (ILiteral oneOf : literals)
                if (literal.equals(oneOf))
                    return true;
            return false;
        }
        protected int getHashCode(DataOneOf oneOf) {
            int hashCode=0;
            for (ILiteral literal : oneOf.m_enumeration)
                hashCode+=literal.hashCode();
            return hashCode;
        }
    };
    public static DataOneOf create(Set<ILiteral> oneOfs) {
        return s_interningManager.intern(new DataOneOf(oneOfs));
    }
    public String getIdentifier() {
        return null;
    }
    public <O> O accept(ExtendedOWLObjectVisitorEx<O> visitor) {
        return visitor.visit(this);
    }
    public Set<Variable> getVariablesInSignature() {
        Set<Variable> variables=new HashSet<Variable>();
        for (ILiteral literal : m_enumeration) {
            variables.addAll(literal.getVariablesInSignature());
        }
        return variables;
    }
}