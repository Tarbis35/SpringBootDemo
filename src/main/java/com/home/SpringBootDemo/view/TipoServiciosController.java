package com.home.SpringBootDemo.view;

import com.home.SpringBootDemo.config.UcmConfig;
import com.home.SpringBootDemo.model.repositories.TipoServicioRepository;
import com.home.SpringBootDemo.services.RIDCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class TipoServiciosController {

    @Autowired
    private TipoServicioRepository tipoServicioRepository;

    @Autowired
    private RIDCService ridcService;

    @RequestMapping(value = "auth/TipoServicios", method = RequestMethod.GET)
    public String getTipoServicios(Model model){
        ridcService.SearchDocs();
        model.addAttribute("tipoServiciosList", tipoServicioRepository.findAll());
        return "TipoServicios";
    }

}
