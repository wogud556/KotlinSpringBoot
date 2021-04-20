package com.hi.udemy.Controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HtmlController {

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

//    @GetMapping("/login")
//    fun htmllogin(model: Model) : String{
//        return "login"
//    }
}

