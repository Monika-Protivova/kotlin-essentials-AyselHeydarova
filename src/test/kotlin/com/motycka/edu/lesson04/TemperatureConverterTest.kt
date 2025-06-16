package com.motycka.edu.lesson04

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

// By convention, the name of the test class should be the name of the class under test + "Test"
class TemperatureConverterTest : StringSpec({

    "convert Fahrenheit to Celsius where fahrenheit is 32" {
        // given
        val fahrenheit = 32.0

        // when
        val celsius = TemperatureConverter.toCelsius(fahrenheit)

        // then
        celsius shouldBe 0.0
    }

    "convert Fahrenheit to Celsius where fahrenheit is 212" {
        // given
        val fahrenheit = 212.0

        // when
        val celsius = TemperatureConverter.toCelsius(fahrenheit)

        // then
        celsius shouldBe 100.0
    }

    "convert Fahrenheit to Celsius where fahrenheit is 98.6" {
        // given
        val fahrenheit = 98.6

        // when
        val celsius = TemperatureConverter.toCelsius(fahrenheit)

        // then
        celsius shouldBe 37.0
    }

    "convert Fahrenheit to Celsius where fahrenheit is negative" {
        // given
        val fahrenheit = -148.0

        // when
        val celsius = TemperatureConverter.toCelsius(fahrenheit)

        // then
        celsius shouldBe -100.0
    }

})
