package com.googlecode.javacpp.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A shorthand for {@code @Cast("std::string&") @Adapter("StringAdapter")}.
 *
 * @see Adapter
 * @see Generator
 *
 * @author Samuel Audet
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Cast("std::string&") @Adapter("StringAdapter")
public @interface StdString { }