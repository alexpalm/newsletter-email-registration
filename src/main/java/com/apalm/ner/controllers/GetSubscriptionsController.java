package com.apalm.ner.controllers;

import com.apalm.ner.constants.ConstantVariables;
import com.apalm.ner.dao.SubscriberDAO;
import com.apalm.ner.entities.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class GetSubscriptionsController implements ConstantVariables {

    @Autowired
    private SubscriberDAO subscriberDAO;

    @GetMapping("/get-subscriptions")
    public  String subscribeForm(HttpServletRequest request, Model model) {

        List<Subscriber> subscribers = this.subscriberDAO.findAll();
        model.addAttribute(SUBSCRIBERS_LIST, subscribers);

        return "get-subscriptions";
    }

}
