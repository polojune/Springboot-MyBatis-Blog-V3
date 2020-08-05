<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@include file ="../layout/header.jsp"%>


<div class="container">
           
  <table class="table table-striped">
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>내용</th>
        <th>작성자</th>     
      </tr>
    </thead>
    <tbody>
             
          <tr>
            <td><input id="id" type="text" value="${postDetailRespDto.id}"readOnly></td>
            <td><input id="title" type="text" value="${postDetailRespDto.title}"readOnly></td>
            <td><input id="content" type="text" value="${postDetailRespDto.content}"readOnly></td>
            <td><input id="username"type="text" value="${postDetailRespDto.username}"readOnly></td>
            <td></td>            
            <td></td>
            <td></td>
          </tr>   
                        
    </tbody>
  </table>
    <button id="btn-update" class="btn btn-primary">수정하기</button>
    <button id="btn-update-mode" class="btn btn-warning">수정</button>
    <button id="btn-delete" class="btn btn-danger">삭제</button>
</div>

    <div class="container">
    <form id="commentForm" name="commentForm" method="post">
    <br><br>
        <div>
            <div>
                <span><strong>Comments</strong></span> <span id="cCnt"></span>
            </div>
            <div>
                <table class="table">                    
                    <tr>
                        <td> 
                            
                            <textarea  id="reply" style="width: 1100px" rows="3" cols="30" name="comment" placeholder="댓글을 입력하세요"></textarea>
                            <br>
                            <div>
                                <button id="btn-reply" type="button" class="btn pull-right btn-success">등록</button>
                                
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <input type="hidden" id="b_code" name="b_code" value="${result.code }" />        
    </form>
</div>
<div class="container">
    <form id="commentListForm" name="commentListForm" method="post">
        <div id="commentList">
        </div>
    </form>
</div>
 
 
<script src="/js/post.js"></script>
<%@include file ="../layout/footer.jsp"%>