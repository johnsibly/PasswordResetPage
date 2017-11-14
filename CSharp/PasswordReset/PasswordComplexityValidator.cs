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
            if ( password1 == password2 &&
                password1.Length >= 8 &&
                password1.Length <= 20 && password2.Length <= 20 &&
                containsLowerCase(password1) && containsLowerCase(password2) &&
                containsUpperCase(password1) && containsUpperCase(password2)
               )
            {
                return true;
            }
            else
            {
                return false;
            }
                   
        }

        bool containsLowerCase(String password)
        {
            foreach (char c in password)
            {
                if (c >= 'a' && c <= 'z')
                {
                    return true;
                }
            }

            return false;
        }

        bool containsUpperCase(String password)
        {
            foreach (char c in password)
            {
                if (c >= 'A' && c <= 'Z')
                {
                    return true;
                }
            }

            return false;
        }
    }
}
