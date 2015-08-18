package me.tomassetti.symbolsolver.model.reflection;

import me.tomassetti.symbolsolver.model.TypeSolver;
import me.tomassetti.symbolsolver.model.declarations.ParameterDeclaration;
import me.tomassetti.symbolsolver.model.declarations.TypeDeclaration;
import me.tomassetti.symbolsolver.model.usages.TypeUsage;
import me.tomassetti.symbolsolver.model.usages.TypeUsageOfTypeDeclaration;

/**
 * Created by federico on 02/08/15.
 */
public class ReflectionParameterDeclaration implements ParameterDeclaration {
    private Class<?> type;

    public ReflectionParameterDeclaration(Class<?> type) {
        this.type = type;
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "ReflectionParameterDeclaration{" +
                "type=" + type +
                '}';
    }

    @Override
    public boolean isField() {
        return false;
    }

    @Override
    public boolean isParameter() {
        return true;
    }

    @Override
    public TypeUsage getTypeUsage(TypeSolver typeSolver) {
        return new TypeUsageOfTypeDeclaration(getType(typeSolver));
    }

    @Override
    public boolean isType() {
        return false;
    }

    @Override
    public TypeDeclaration getType(TypeSolver typeSolver) {
        return new ReflectionClassDeclaration(type);
    }
}