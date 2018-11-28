package client.controller;

import client.service.UserService;
import client.model.Student;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {

  @Autowired
  private UserService userService;
  private String UPLOAD = "/home/dmitry/IdeaProjects/hibernate/client/src/main/upload/";

  @GetMapping("/main")
  public String user(final Model model, final Principal principal) {
    List<Student> students = userService.getAll();
    List<Student> sortedList = students.stream().distinct()
        .filter(student -> student.getName()
        .equals(principal.getName().replaceAll(" .*", ""))).collect(
        Collectors.toList());
    model.addAttribute("students", sortedList);
    model.addAttribute("principal", principal.getName());
    return "main";
  }

  @PostMapping("/upload")
  public String handleFileUpload(@RequestParam("file") MultipartFile file,
      final Principal principal) throws IOException {
    byte[] bytes = file.getBytes();
    List<Student> students = userService.getAll();
    List<Student> sortedList = students.stream().distinct()
        .filter(student -> student.getName()
            .equals(principal.getName().replaceAll(" .*", "")))
        .collect(
            Collectors.toList());
    Student student = sortedList.get(0);
    student.setImage(bytes);
    System.out.println(student.getName());
    userService.updateStudent(student);

    return "redirect:/main";
  }

}
