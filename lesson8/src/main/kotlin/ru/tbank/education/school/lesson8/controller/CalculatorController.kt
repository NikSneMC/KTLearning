package ru.tbank.education.school.lesson8.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CalculatorController {
    @RequestMapping("/calculate", method = [RequestMethod.GET])
    fun getGreeting(@RequestParam("a") a: Long, @RequestParam("b") b: Long): String {
        return "$a + $b = ${a + b}"
    }
}
