package ru.tbank.education.school.lesson8.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.tbank.education.school.lesson8.dto.AddUserBody
import ru.tbank.education.school.lesson8.dto.EditUserBody
import ru.tbank.education.school.lesson8.dto.User
import ru.tbank.education.school.lesson8.service.UserService

@RestController
class UserController(private val userService: UserService) {
    @PostMapping("/user")
    fun addUser(@RequestBody user: AddUserBody): ResponseEntity<User> {
        val createdUser = userService.addUser(user)
        return if (createdUser == null) ResponseEntity.badRequest().build()
        else ResponseEntity.ok(createdUser)
    }

    @GetMapping("/user/{id}")
    fun getUser(@PathVariable id: Int): ResponseEntity<User> {
        val user = userService.getUser(id)
        return if (user == null) ResponseEntity.notFound().build() else ResponseEntity.ok(user)
    }

    @PatchMapping("/user/{id}")
    fun editUser(@PathVariable id: Int, @RequestBody user: EditUserBody) =
            userService.editUser(id, user)

    @DeleteMapping("/user/{id}")
    fun removeUser(@PathVariable id: Int): ResponseEntity<Void> =
            if (userService.removeUser(id)) ResponseEntity.noContent().build()
            else ResponseEntity.notFound().build()
}
