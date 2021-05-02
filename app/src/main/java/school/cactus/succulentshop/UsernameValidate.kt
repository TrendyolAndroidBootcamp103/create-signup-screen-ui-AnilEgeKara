package school.cactus.succulentshop

import android.util.Log
import java.util.regex.Matcher
import java.util.regex.Pattern

class UsernameValidate:Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.username_required
        field.length < 2 -> R.string.username_too_short
        field.length > 20 -> R.string.username_too_long
        !isValidUsername(field) -> R.string.username_patern
        else -> null
    }

    private fun isValidUsername(username: String?): Boolean {
        val pattern: Pattern
        val usernamePatern = "^[a-zA-Z0-9_]+$"
        pattern = Pattern.compile(usernamePatern)
        val matcher: Matcher = pattern.matcher(username)
        Log.d("regex", "${matcher.matches()}")
        return matcher.matches()
    }
}