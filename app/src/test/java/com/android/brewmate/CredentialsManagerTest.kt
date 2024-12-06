package com.android.brewmate

import org.junit.Assert.*
import org.junit.Test

class CredentialsManagerTest {

    @Test
    fun `empty email returns false`() {
        val result = CredentialsManager.isEmailValid("")
        assertFalse(result)
    }

    @Test
    fun `wrong format email returns false`() {
        val result = CredentialsManager.isEmailValid("invalid-email")
        assertFalse(result)
    }

    @Test
    fun `well formatted email returns true`() {
        val result = CredentialsManager.isEmailValid("example@example.com")
        assertTrue(result)
    }

    @Test
    fun `empty password returns false`() {
        val result = CredentialsManager.isPasswordValid("")
        assertFalse(result)
    }

    @Test
    fun `filled password returns true`() {
        val result = CredentialsManager.isPasswordValid("password123")
        assertTrue(result)
    }

    @Test
    fun `register returns success when email is new`() {
        val result = CredentialsManager.register("newuser@example.com", "password123")
        assertTrue(result.isSuccess)
        assertEquals("Registration successful", result.getOrNull())
    }

    @Test
    fun `register returns failure when email is already registered`() {
        CredentialsManager.register("duplicate@example.com", "password123")
        val result = CredentialsManager.register("duplicate@example.com", "password123")
        assertTrue(result.isFailure)
        assertEquals("Email is already registered", result.exceptionOrNull()?.message)
    }
}
