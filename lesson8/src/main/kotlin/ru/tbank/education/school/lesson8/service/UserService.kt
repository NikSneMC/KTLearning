package ru.tbank.education.school.lesson8.service

import org.springframework.stereotype.Component
import ru.tbank.education.school.lesson8.dao.UserRepository
import ru.tbank.education.school.lesson8.dto.AddUserBody
import ru.tbank.education.school.lesson8.dto.EditUserBody

@Component
class UserService(private val userRepository: UserRepository) {
    fun addUser(user: AddUserBody) = userRepository.addUser(user.username, user.fullName, user.age)
    fun getUser(id: Int) = userRepository.getUser(id)
    fun editUser(id: Int, user: EditUserBody) =
            userRepository.updateUser(id, user.username, user.fullName, user.age)
    fun removeUser(id: Int) = userRepository.removeUser(id)
}
