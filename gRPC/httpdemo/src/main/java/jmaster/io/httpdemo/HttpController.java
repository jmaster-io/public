package jmaster.io.httpdemo;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HttpController {

    @GetMapping("/json")
    public List<Person> get() {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 1000; i++)
            personList.add(new Person(1, "Test", 20));

        return personList;
    }

    @GetMapping(value = "/download/{id}",produces = "image/jpg")
    public void download1(HttpServletResponse response) throws IOException {
        Resource resource = new ClassPathResource("demo.jpg");
        Files.copy(resource.getFile().toPath(), response.getOutputStream());
    }
}

class Person {
    private int id;
    private String name;
    private int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
