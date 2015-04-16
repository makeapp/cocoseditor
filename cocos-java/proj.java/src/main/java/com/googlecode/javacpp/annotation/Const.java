package com.googlecode.javacpp.annotation;


import com.googlecode.javacpp.FunctionPointer;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A shortcut annotation to {@link Cast} that simply adds {@code const} to the parameter type.
 * Can also be declared on a {@link FunctionPointer} in the case of {@code const} functions.
 *
 * @see Generator
 *
 * @author Samuel Audet
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
public @interface Const {
    /** If {@code true}, applies {@code const} to the value and to the pointer, respectively. */
    boolean[] value() default {true, false};
}
