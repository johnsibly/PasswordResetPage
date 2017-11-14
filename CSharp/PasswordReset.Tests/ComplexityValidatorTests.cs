using NUnit.Framework;
using System;
using PasswordReset;

namespace PasswordReset.Tests
{
    [TestFixture()]
    public class ComplexityValidatorTests
    {
        [Test()]
        public void Validate_ShouldReturnFalseIfPasswordsDoNoMatch()
        {
            PasswordComplexityValidator validator = new PasswordComplexityValidator();

            Assert.False(validator.Validate("ThisIsMyPassword", "ThisPasswordIsDifferent"));
        }

        [Test()]
        public void Validate_ShouldReturnTrueIfPasswordsMatch()
        {
            PasswordComplexityValidator validator = new PasswordComplexityValidator();

            Assert.True(validator.Validate("ThisIsMyPassword", "ThisIsMyPassword"));
        }

        [Test()]
        public void Vaildate_ShouldBeGreaterThan8CharactersInLength()
        {
            PasswordComplexityValidator validator = new PasswordComplexityValidator();
            Assert.False(validator.Validate("Passwor", "Passwor"));
        }

        [Test()]
        public void Vaildate_MustNotBeGreaterThan20CharactersInLength()
        {
            PasswordComplexityValidator validator = new PasswordComplexityValidator();
            Assert.False(validator.Validate("Password10Password10X", "Password10Password10X"));
        }

        [Test()]
        public void Vaildate_MustContainALowerCaseCharacters()
        {
            PasswordComplexityValidator validator = new PasswordComplexityValidator();
            Assert.False(validator.Validate("PASSWORD", "PASSWORD"));
        }

        [Test()]
        public void Vaildate_MustContainAnUpperCaseCharacter()
        {
            PasswordComplexityValidator validator = new PasswordComplexityValidator();
            Assert.False(validator.Validate("password", "password"));
        }

    }
}
