package com.hi.udemy.repository

import com.hi.udemy.entity.User
import org.springframework.data.repository.CrudRepository

//레퍼지토리 생성시 인터페이스로 생성함
interface UserRepository:CrudRepository<User,Long> {//엔티티명과 ID의 형을 입력함
    fun findByUserId(userId : String): User

}