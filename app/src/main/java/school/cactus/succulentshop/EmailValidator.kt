package school.cactus.succulentshop


class EmailValidator:Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.email_invalid
        field.length < 5 -> R.string.email_invalid
        !field.contains('@') -> R.string.email_invalid
        else -> null
    }
}