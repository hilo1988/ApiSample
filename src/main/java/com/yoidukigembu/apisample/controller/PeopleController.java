package com.yoidukigembu.apisample.controller;

import com.yoidukigembu.apisample.condition.SearchCondition;
import com.yoidukigembu.apisample.db.entity.PersonEntity;
import com.yoidukigembu.apisample.json.request.person.ResisterRequest;
import com.yoidukigembu.apisample.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hilo on 2017/07/18.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("person")
public class PeopleController {

    private final PersonService service;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public long register(@RequestBody ResisterRequest request) {
        return service.register(request);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<PersonEntity> list(@ModelAttribute SearchCondition condition) {
        return service.search(condition);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PersonEntity detail(@PathVariable long id) {
        return service.getDetail(id);
    }

}
