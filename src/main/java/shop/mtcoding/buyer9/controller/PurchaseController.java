package shop.mtcoding.buyer9.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.buyer9.dto.PurchaseAllDto;
import shop.mtcoding.buyer9.model.PurchaseRepository;
import shop.mtcoding.buyer9.model.User;
import shop.mtcoding.buyer9.service.PurchaseService;

@Controller
public class PurchaseController {

    @Autowired
    HttpSession session;

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    PurchaseService purchaseService;

    @PostMapping("/purchase/insert")
    public String insert(int productId, int count) {
        // 인증
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/notfound";
        }

        // 트랜잭션
        int res = purchaseService.구매하기(productId, principal.getId(), count);
        if (res == -1) {
            return "redirect:/notfound";
        }

        return "redirect:/";
    }

    @GetMapping("/purchase")
    public String purchase(Model model) {
        // 인증
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/notfound";
        }

        List<PurchaseAllDto> purchaseList = purchaseRepository.findByUserId(principal.getId());
        model.addAttribute("purchaseList", purchaseList);

        return "purchase/list";
    }

    @PostMapping("/purchase/delete")
    public String delete(int purchaseId) {
        // 인증
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/notfound";
        }

        // 트랜잭션
        int res = purchaseService.삭제하기(purchaseId);
        if (res != 1) {
            return "redirect:/notfound";
        }

        return "redirect:/purchase";
    }

}
