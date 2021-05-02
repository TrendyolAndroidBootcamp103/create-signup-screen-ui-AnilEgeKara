package school.cactus.succulentshop

import android.util.Log
import java.util.regex.Matcher
import java.util.regex.Pattern

class PasswordValidator : Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.this_field_is_required
        else -> null
    }
}

class PasswordValidatorSignUp : Validator {

    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.password_is_required
        field.length < 7 -> R.string.password_too_short
        field.length > 40 -> R.string.password_too_long
        !isValidPassword(field) -> R.string.password_patern
        else -> null
    }

    private fun isValidPassword(password: String?): Boolean {
        val pattern: Pattern
        val passwordPatern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$%&#])[a-zA-Z0-9_@$%&#].{8,39}$"
        pattern = Pattern.compile(passwordPatern)
        val matcher: Matcher = pattern.matcher(password)
        return matcher.matches()
    }
}