package com.googlecode.javacpp.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that an argument gets passed or returned by reference. When used
 * alongside {@link com.googlecode.javacpp.FunctionPointer}, the {@link com.googlecode.javacpp.Generator} passes the underlying
 * C++ function object (aka functor) instead of a function pointer.
 *
 * @see com.googlecode.javacpp.Generator
 *
 * @author Samuel Audet
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
public @interface ByRefPtr
{ }