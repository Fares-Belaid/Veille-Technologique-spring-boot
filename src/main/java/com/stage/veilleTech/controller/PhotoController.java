//package com.stage.veilleTech.controller;
//
////import com.stage.veilleTech.services.strategy.StrategyPhotoContext;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import com.flickr4java.flickr.FlickrException;
//import java.io.IOException;
//@RestController
//@RequestMapping("/photo")
//public class PhotoController {
//
//    private StrategyPhotoContext strategyPhotoContext;
//
//    @Autowired
//    public PhotoController(StrategyPhotoContext strategyPhotoContext) {
//        this.strategyPhotoContext = strategyPhotoContext;
//    }
//
//    @PostMapping("/save/{id}/{title}/{context}")
//    public Object savePhoto(@PathVariable("context") String context, @PathVariable("id") Integer id, @RequestPart("file") MultipartFile photo,@PathVariable("title") String title) throws IOException, FlickrException {
//        return strategyPhotoContext.savePhoto(context, id, photo.getInputStream(), title);
//    }
//}
