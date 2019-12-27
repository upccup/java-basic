package com.yaoyun.binarysearch;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author yaoyun created on 12月 10, 2019
 * @version 1.0
 */
public class NextGreatestLetterTest {

    @Test
    public void nextGreatestLetter() {
        char result = NextGreatestLetter.nextGreatestLetter(new char[]{'c', 'f', 'j'},'a');
        assertEquals(result, 'c');
        result = NextGreatestLetter.nextGreatestLetter(new char[]{'c', 'f', 'j'},'c');
        assertEquals(result, 'f');
        result = NextGreatestLetter.nextGreatestLetter(new char[]{'c', 'f', 'j'},'d');
        assertEquals(result, 'f');
        result = NextGreatestLetter.nextGreatestLetter(new char[]{'c', 'f', 'j'},'g');
        assertEquals(result, 'j');
        result = NextGreatestLetter.nextGreatestLetter(new char[]{'c', 'f', 'j'},'k');
        assertEquals(result, 'c');
        result = NextGreatestLetter.nextGreatestLetter(new char[]{'c', 'f', 'j'},'z');
        assertEquals(result, 'c');
    }
}