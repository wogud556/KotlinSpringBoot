package com.hi.udemy.Controller

import com.hi.udemy.entity.User
import com.hi.udemy.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class HtmlController {
    //lateinit 나중에 초기화를 하겠다는 의미 스프링이 밖에서 초기화를 해주고 자원관리를 하게 되어있음 그걸 autowired로 함
    @Autowired //bean을 자동으로 만들고 init도 하는 어노테이션 스프링부트가 자체적을 자원관리를 하게끔 함
    lateinit var repository: UserRepository

    @GetMapping("/") //@GetMapping 일때
    fun index(model:Model) : String {
//        return ''
//        println("index method")
        model.addAttribute("title","Home")
        return "index" // 메소드가 index라는 것을 인지하면 template 하위에 있는 index.html을 읽어 들어온다.(jsp 불러오는방식과 동일함)
    }

    @GetMapping("/post/{num}") //@GetMapping 일때
    fun post(model: Model, @PathVariable num : Int){ // PathVariable url에서 받아오는 데이터를 가져옴
        println("num:\t${num}")
    }

    @GetMapping("/{formType}")
    fun htmlForm(model: Model , @PathVariable formType:String) : String{ //리턴타입이 nullable이면 함수의 형도 nullable이 되어야 함(? 추가)

        var response: String  = ""
        if(formType.equals("sign")){
            response = "sign"
        }else if(formType.equals("login")){
            response = "login"
        }
        model.addAttribute("title", response)

        return response
    }

    @PostMapping("/sign")
    fun postSign(model: Model,
                 @RequestParam(value = "id") userId : String,
                 @RequestParam(value = "password") password:String) :String{
        try{
            val user = repository.save(User(userId, password))
            println(user.toString())
        }catch (e: Exception){
            e.printStackTrace()
        }
        return "index"
    }

//    @GetMapping("/login")
//    fun htmllogin(model: Model) : String{
//        return "login"
//    }
}

