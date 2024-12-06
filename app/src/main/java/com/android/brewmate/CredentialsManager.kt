package com.android.brewmate

object CredentialsManager {
    private val userDatabase: MutableMap<String, String> = mutableMapOf()
    private val accounts = mutableMapOf<String, String>()

    fun isEmailValid(email: String): Boolean {
        if (email.isEmpty()) return false
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
        return email.matches(emailRegex)
    }

    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty()
    }

    fun register(email: String, password: String): Result<String> {
        val normalizedEmail = email.lowercase().trim()

        if (userDatabase.containsKey(normalizedEmail)) {
            return Result.failure(Exception("Email is already registered"))
        }

        userDatabase[normalizedEmail] = password
        return Result.success("Registration successful")
    }


    fun login(email: String, password: String): Boolean {
        val normalizedEmail = email.lowercase()
        return accounts[normalizedEmail] == password
    }
}
