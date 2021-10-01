package com.example.itquiz


import com.google.common.truth.Truth.assertThat
import com.google.commons.Truth.truth
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import javax.xml.validation.Validator

@RunWith(JUnit4::class)

class validatorTest{

    @Test
    fun whenInputIsValid(){
        val amount = 100
        val desc = "Some Random Desc"
        val result = validator.validateInput(amount, desc)

        assertThat(result).isEqualTo(true)

    }

    @Test
    fun whenInputIsInalid(){
        val amount = 0
        val desc = ""
        val result = validator.validateInput(amount, desc)

        assertThat(result).isEqualTo(false)

    }

}