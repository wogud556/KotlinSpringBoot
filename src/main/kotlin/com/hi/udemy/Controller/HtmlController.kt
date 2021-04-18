package com.hi.udemy.Controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HtmlController {

    @RequestMapping("/")
    fun index(model:Model) : String {
//        return ''
//        println("index method")
        return "index" // 메소드가 index라는 것을 인지하면 template 하위에 있는 index.html을 읽어 들어온다.(jsp 불러오는방식과 동일함)
    }
}

