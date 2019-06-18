package com.apalm.ner.controllers;

import com.apalm.ner.constants.ConstantVariables;
import com.apalm.ner.dao.SubscriberDAO;
import com.apalm.ner.entities.Subscriber;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SubscribeController implements ConstantVariables {

    @Autowired
    private SubscriberDAO subscriberDAO;

    @GetMapping("/subscribe")
    public  String subscribeForm() {
        return "subscribe-form";
    }

    @PostMapping("/subscribe")
    public String subscribe(HttpServletRequest request, Model model) {

        String fullName = request.getParameter(PARAM_NAME);
        String email = request.getParameter(PARAM_EMAIL);

        if (!StringUtils.isBlank(fullName) && !StringUtils.isBlank(email)) {
            Subscriber newSubscriber = new Subscriber();
            newSubscriber.setFullName(fullName);
            newSubscriber.setEmail(email);
            this.subscriberDAO.save(newSubscriber);
            model.addAttribute(NEW_SUBSCRIBER, newSubscriber);
        }

        List<Subscriber> subscribers = this.subscriberDAO.findAll();
        model.addAttribute(SUBSCRIBERS_LIST, subscribers);

        return "subscribed";
    }

}
