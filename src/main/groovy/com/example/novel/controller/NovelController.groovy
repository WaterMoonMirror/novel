package com.example.novel.controller

import lombok.extern.slf4j.Slf4j
import org.apache.juli.logging.Log
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import java.util.regex.Matcher
import java.util.regex.Pattern

@RestController
@RequestMapping("/novel")
@Slf4j
class NovelController {
    // 编码格式
    String encoding = "GBK";

    @GetMapping
    public String add(){
        def file=new File("D:\\groovyWork\\novel\\novel\\950煌夜祭.txt")
        file.withReader(encoding){
            it.eachLine {line->
                // "(^\\s*第)(.{1,9})[章节卷集部篇回](\\s{0})(.*)($\\s*)"
                def rex="((^\\s*第)(.{1,9})[章节卷集部篇回](\\s{0})(.*)(\$\\s*))";
                Pattern p = Pattern.compile(rex);
                Matcher m =p.matcher(line);
               if (m.find()){println(m.group(1))}
                line.split()
            }
        }
        return "ok";
    }
}
