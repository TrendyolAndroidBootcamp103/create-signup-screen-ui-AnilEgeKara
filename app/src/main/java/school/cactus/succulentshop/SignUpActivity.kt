package school.cactus.succulentshop

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import school.cactus.succulentshop.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    private val emailValidator= EmailValidator()
    private val usernameValidator = UsernameValidate()
    private val passwordValidator = PasswordValidatorSignUp()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        binding = ActivitySignUpBinding.inflate(layoutInflater)

        findViewById<Button>(R.id.signInButton).setOnClickListener {
            Log.d("tag","sign in")
            findViewById<TextInputLayout>(R.id.emailInputLayout).validate()
            findViewById<TextInputLayout>(R.id.usernameInputLayout).validate()
            findViewById<TextInputLayout>(R.id.passwordInputLayout).validate()
        }
        findViewById<Button>(R.id.alreadyHaveAnAccountButton).setOnClickListener {
            navigateToLogInActivity()
        }
        /*binding.apply {

            alreadyHaveAnAccountButton.setOnClickListener {
                navigateToLogInActivity()
            }
        }*/
    }

    private fun navigateToLogInActivity() {
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }

    private fun TextInputLayout.validate() {
        val errorMessage = validator().validate(editText!!.text.toString())
        error = errorMessage?.resolveAsString()
        isErrorEnabled = errorMessage != null
    }

    private fun Int.resolveAsString() = getString(this)

    private fun TextInputLayout.validator() = when (this) {
        findViewById<TextInputLayout>(R.id.emailInputLayout)->emailValidator
        findViewById<TextInputLayout>(R.id.usernameInputLayout) -> usernameValidator
        findViewById<TextInputLayout>(R.id.passwordInputLayout) -> passwordValidator
        else -> throw IllegalArgumentException("Cannot find any validator for the given TextInputLayout")
    }
}