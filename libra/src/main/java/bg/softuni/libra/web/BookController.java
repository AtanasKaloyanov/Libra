package bg.softuni.libra.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

public class BookController {
//    @GetMapping("/offers/add")
//    public String addOffer(Model model) {
//        if (!model.containsAttribute("addOfferModel")) {
//            model.addAttribute("addOfferModel", new AddOfferDTO());
//        }
//        model.addAttribute("brands", brandService.getAllBrands());
//
//        return "offer-add";
//    }
//
//    @PostMapping("/offers/add")
//    public String addOffer(@Valid AddOfferDTO addOfferModel,
//                           BindingResult bindingResult,
//                           RedirectAttributes redirectAttributes,
//                           @AuthenticationPrincipal UserDetails userDetails) {
//
//        if (bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("addOfferModel", addOfferModel);
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferModel",
//                    bindingResult);
//            return "redirect:/offers/add";
//        }
//
//        offerService.addOffer(addOfferModel, userDetails);
//
//        return "redirect:/offers/all";
//    }
}
