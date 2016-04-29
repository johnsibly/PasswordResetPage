package com.sky.nowtvpasswordreset;

/**
 * Created by jsi14 on 29/04/16.
 */
public interface IPasswordReUseChecker {
    // Internally this method will hash newPassword, before having another class compare with previously hashed values
    boolean HasPasswordBeenUsedBefore(String newPassword);
}
