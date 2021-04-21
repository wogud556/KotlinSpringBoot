package com.hi.udemy.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity // 해당 클래스는 테이블에 해당한다.
class User (
        var userId:String,
        var password:String,
        @Id @GeneratedValue var id:Long?=null
)

// 대충 테이블 선언이라고 생각하면 된다는 것.

//CREATE TABLE USER(
//  userId TEXT NOT NULL,
//  password VARCHAR(20) NOT NULL,
//  id LONG NOT NULL PRIME KEY
// )
//@GeneratedValue 자동적으로생성
//@Id primary key