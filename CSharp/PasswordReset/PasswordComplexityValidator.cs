using System;
namespace PasswordReset
{
    public class PasswordComplexityValidator
    {
        public PasswordComplexityValidator()
        {
        }

        public bool Validate(String password1, String password2)
        {
            return password1 == password2;
        }
    }
}
