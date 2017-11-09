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

            Assert.False(validator.Validate("ThisIsMyPassword", "ThisPassWordIsDifferent"));
        }

        [Test()]
        public void Validate_ShouldReturnTrueIfPasswordsMatch()
        {
            PasswordComplexityValidator validator = new PasswordComplexityValidator();

            Assert.True(validator.Validate("ThisIsMyPassword", "ThisIsMyPassword"));
        }

        public void MockTest()
        {
            var mockPasswordReUseChecker = Mock.Interface<IPasswordReUseChecker>();

        }
    }
}
