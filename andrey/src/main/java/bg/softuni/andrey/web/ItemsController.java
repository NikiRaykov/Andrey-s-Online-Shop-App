package bg.softuni.andrey.web;

import bg.softuni.andrey.model.entity.binding.ItemBindingModel;
import bg.softuni.andrey.model.entity.service.ItemServiceModel;
import bg.softuni.andrey.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/items")
public class ItemsController {

    private final ItemService itemService;
    private final ModelMapper modelMapper;

    public ItemsController(ItemService itemService, ModelMapper modelMapper) {
        this.itemService = itemService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model) {
        if (!model.containsAttribute("ïtemBindingModel")) {
            model.addAttribute("ïtemBindingModel", new ItemBindingModel());
        }

        return "add-item";
    }

    @PostMapping("/add")
    public String confirmAdd(@Valid ItemBindingModel itemBindingModel, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("itemBindingModel", itemBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.itemBindingModel", bindingResult);

            return "redirect:add";
        }

        itemService
                .addItem(modelMapper.map(itemBindingModel, ItemServiceModel.class));

        return "redirect:/";
    }

    @GetMapping("/details")
    public ModelAndView details(@RequestParam("id") Long id, ModelAndView modelAndView) {

        modelAndView.addObject("item", itemService.findById(id));
        modelAndView.setViewName("details-item");

        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        itemService.delete(id);

        return "redirect:/";
    }


    @ModelAttribute
    public ItemBindingModel itemBindingModel() {
        return new ItemBindingModel();
    }
}
