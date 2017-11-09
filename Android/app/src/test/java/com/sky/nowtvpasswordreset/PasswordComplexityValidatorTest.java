package com.sky.nowtvpasswordreset;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by jsi14 on 15/04/16.
 */
public class PasswordComplexityValidatorTest {
    @Test
    public void Validate_shouldReturnFalseIfPasswordsDoNoMatch() throws Exception {

        PasswordComplexityValidator validator = new PasswordComplexityValidator(null);

        assertFalse (validator.Validate("ThisIsMyPassword", "ThisPassWordIsDifferent"));
    }

    @Test
    public void Validate_shouldReturnTrueIfPasswordsMatch() throws Exception {

        PasswordComplexityValidator validator = new PasswordComplexityValidator(null);

        assertTrue (validator.Validate("ThisIsMyPassword", "ThisIsMyPassword"));
    }
    
}