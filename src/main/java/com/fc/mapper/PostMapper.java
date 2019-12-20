package com.fc.mapper;

import com.fc.model.Post;
import com.fc.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface PostMapper {


    List<Post> listPostByUid(int uid);

    int insertPost(Post post);

    List<Post> listPostByTime(@Param("offset") int offset, @Param("limit") int limit);

    List<Post> listPostByHeat(@Param("offset") int offset, @Param("limit") int limit);

    List<Post> listAllPost();

    int selectPostCount();

    Post getPostByPid(int pid);

    void updateReplyCount(int pid);

    void updateScanCount(int pid);

    void updateReplyTime(int pid);

    int getUidByPid(int pid);

    String getTitleByPid(int pid);

    void setTopPost(int pid);

    int returnTop();

    void editEssay(@Param("pid") int pid, @Param("content") String content);
}
