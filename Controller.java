//Controller, exemplifica através de diversas solicitações em HTML onde ele coordena as visões e modelo.

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BlogController {
    private List<String> posts = new ArrayList<>();

    @GetMapping("/")
    public String listPosts(Model model) {
        model.addAttribute("posts", posts);
        return "list_posts";
    }

    @GetMapping("/create")
    public String showCreatePostForm() {
        return "create_post";
    }

    @PostMapping("/create")
    public String createPost(@RequestParam String title) {
        posts.add(title);
        return "redirect:/";
    }
}
