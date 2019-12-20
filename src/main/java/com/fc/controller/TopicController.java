package com.fc.controller;

import com.fc.model.Post;
import com.fc.model.Topic;
import com.fc.service.PostService;
import com.fc.service.TopicService;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private PostService PostService;

    /**
     * 列出所有话题
     * @param model
     * @return
     */
    @RequestMapping("/listTopic.do")
    public String listTopic(Model model){
        List<Topic> topicList = topicService.listTopic();
        model.addAttribute("topicList",topicList);
        return "topic";
    }

    @RequestMapping("/listImage.do")
    public String listImage(Model model){
//        List<String> imageList = topicService.listImage();
//        model.addAttribute("imageList",imageList);
        List<Post> postList = PostService.listAllPost();
        model.addAttribute("postList",postList);
        return "image";
    }

    @RequestMapping("/setTop.do")
    public String setTop(int pid,Model model){
//        int pid=request.getParameter("pid");

        PostService.setTopPost(pid);
//        List<Post> postList = PostService.listAllPost();
//        model.addAttribute("postList",postList);
        return "redirect:/toIndex.do";
    }

    @RequestMapping(value = "/editEssay.do",method= RequestMethod.POST)
    public String editEssay(Model model, @RequestParam(value="pid") int pid
            , @RequestParam(value="content") String content, HttpServletResponse response,HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PostService.editEssay(pid,content);
//        PrintWriter out=response.getWriter();
//        out.println(pid);
//        out.println(content);
//        List<Post> postList = PostService.listAllPost();
//        model.addAttribute("postList",postList);
        return "redirect:/toIndex.do";
    }


}





