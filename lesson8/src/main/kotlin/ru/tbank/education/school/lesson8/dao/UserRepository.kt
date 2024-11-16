package ru.tbank.education.school.lesson8.dao

import kotlin.random.Random
import org.springframework.stereotype.Component
import ru.tbank.education.school.lesson8.dto.User

@Component
class UserRepository {
    private val users = mutableListOf<User>()

    fun addUser(username: String, fullName: String, age: Int): User? {
        var id: Int
        do {
            id = Random.nextInt(0, Int.MAX_VALUE)
        } while (this.getUser(id) != null)
        return if (users.add(User(id, username, fullName, age))) this.getUser(id) else null
    }
    fun getUser(id: Int): User? = users.find { it.id == id }
    fun updateUser(id: Int, username: String?, fullName: String?, age: Int?): User? {
        val user: User? = this.getUser(id)
        if (user == null) {
            return null
        }
        user.let {
            it.username = username ?: it.username
            it.fullName = fullName ?: it.fullName
            it.age = age ?: it.age
        }
        val updatedUser = this.getUser(id)!!
        return updatedUser
    }
    fun removeUser(id: Int) = users.removeIf { it.id == id }
}
