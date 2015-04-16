package com.googlecode.javacpp.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Overrides the detection of allocators, getters, and setters. Indicates to the
 * {@link Generator} that we wish the method to call the corresponding C++ function.
 *
 * @see Allocator
 * @see ArrayAllocator
 * @see MemberGetter
 * @see MemberSetter
 * @see ValueSetter
 * @see ValueGetter
 * @see Generator
 *
 * @author Samuel Audet
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Function { }