package in.Inventory_Control.Inventory_Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

//  登録画面
    @GetMapping("/register")
    public String showRegisterPage(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title", "新規登録画面");
        return "register";
    }

//  新規登録
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model){
        User newUser = userService.createUser(user);
        if(newUser != null){
            return "redirect:/login";
        } else {
            model.addAttribute("errorMessage","ユーザー登録に失敗しました。もう一度お試しください");
            return "register";
        }
    }


//  ログイン画面
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "ログイン画面");
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, Model model) {
        User authenticateUser = userService.authenticateUser(user);
        if (authenticateUser != null) {
            return "redirect:/users";
        } else {
            model.addAttribute("errorMassage","ユーザー名又はパスワードが間違っています");
            return "login";
        }
    }

    @GetMapping
    public ResponseEntity<List<User>>getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

//  一覧画面
    @GetMapping("/users")
    public String showAllUsers(Model model, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5")Integer size) {
        List<User> users = userService.getAllUsers(page, size);
        Optional<Long> totalUsers = userService.getTotalUsers();
        int totalPages = 0;
        if(totalUsers.isPresent() && size != null && size != 0){
            totalPages = (int)Math.ceil((double)totalUsers.get() /size);
        }
        model.addAttribute("users", users);
        model.addAttribute("title", "ユーザ一覧画面");
        model.addAttribute("isSearchResult", false);
        model.addAttribute("returnUrl", "/dashboard");
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page != null ? page : 1);
        model.addAttribute("currentPages", page);
        return "/users";
    }

    // 検索画面
    @GetMapping("/user/search")
    public String searchUser(@RequestParam("username") String username, Model model, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        List<User> users = userService.findByName(username, page, size);
        Optional<Long> totalUsers = userService.countByName(username);
        int totalPages = 0;
        if (totalUsers.isPresent() && size != null && size != 0) {
            totalPages = (int)Math.ceil((double) totalUsers.get() / size);
        }
        model.addAttribute("users", users);
        model.addAttribute("title", "ユーザ検索結果");
        model.addAttribute("isSearchResult",true);
        model.addAttribute("returnUrl", "/users");
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page != null ? page : 1);
        model.addAttribute("currentPages", page);
        return "users";
    }


//  詳細画面
    @GetMapping("/user/{id}")
    public String showUserDetailsPage(@PathVariable long id, Model model) {
        User user = userService.findById(id);
        if (user != null) {
            model.addAttribute("user", user);
            model.addAttribute("title", "ユーザ詳細画面");
            return "user_detail";
        } else {
            return "redirect:/users";
        }
    }

//  編集画面
    @GetMapping("/user/edit/{id}")
    public String showEditUserPage(@PathVariable long id, Model model) {
        User user = userService.findById(id);
        if (user != null) {
            model.addAttribute("user", user);
            model.addAttribute("title", "ユーザ編集画面");
            return "user_edit";
        } else {
            return "redirect:/users";
        }
    }

//　更新画面
    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable long id, @ModelAttribute User user, RedirectAttributes redirectAttributes){
        User updateUser = userService.updateUser(user);
        if (updateUser != null) {
            redirectAttributes.addFlashAttribute("successMessage", "ユーザ情報が更新されました");
            return "redirect:/users";
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "更新が失敗しました");
            return "redirect:/users";
        }
    }

//  削除画面
    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        User user = userService.findById(id);
        if(user != null){
            userService.deleteUser(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
