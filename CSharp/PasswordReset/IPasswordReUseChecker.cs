using System;
namespace PasswordReset
{
    public interface IPasswordReUseChecker
    {
        // Internally this method will hash newPassword, before having another class compare with previously hashed values
        bool HasPasswordBeenUsedBefore(String newPassword);
    }
}
