<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../includes/header.jsp" %>
    
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Board List</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Board List Page
                <button id="regBtn" type="button" class="btn btn-xs pull-right">
                		Register New Board
                </button>
                
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <table width="100%" class="table table-striped table-bordered table-hover" >
                    <thead>
                        <tr>
                            <th>#번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성일</th>
                            <th>수정일</th>
                        </tr>
                    </thead>
                    
                    <c:forEach var="board" items="${list}">
                        <tr class="odd gradeX">
                            <td>${board.bno}</td>
                            
                            <td><a href="/board/get?bno=${board.bno}">${board.title}</td>
                            
                            <td>${board.writer}</td>
                            <td><fmt:formatDate value="${board.regdate}" 
                            pattern="yyyy-MM-dd"  /></td>
                            <td><fmt:formatDate value="${board.updateDate}" 
                            pattern="yyyy-MM-dd"  /></td>
                        </tr>
                     </c:forEach>   
                </table>
                
          <!-- 모달창 추가 -->
		  <div class="modal" id="myModal">
		    <div class="modal-dialog">
		      <div class="modal-content">
		      
		        <!-- Modal Header -->
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title" id="myModalLabel">Modal Title</h4>
		        </div>
		        <!-- Modal body -->
		        <div class="modal-body">
		          처리가 완료되었습니다.
		        </div>
		        <!-- Modal footer -->
		        <div class="modal-footer">
		          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
		        </div>
		      </div>
		    </div>
		  </div>     
           <!-- /모달창 추가 -->     
                
                
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
  
<script>
	$(document).ready(function(){
		var result = '<c:out value="${result}" />';
		
		checkModal(result);
		
		
		//모달창
		function checkModal(result){
			if(result === ""){
				return;
			}
			if(parseInt(result)>0){
				$(".modal-body").html("게시글 " + parseInt(result)+"번이 등록되었습니다.");
			}
			$("#myModal").modal("show");
		}
		
		//register 호출
		$("#regBtn").on("click",function(){
			self.location = "/board/register";
		});
		
		
	});
</script>  
  
  
  
  
  
  
  
  
            
<%@ include file="../includes/footer.jsp" %> 