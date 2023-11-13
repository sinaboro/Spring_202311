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
                <button id="regBtn" type="button" class="btn btn-xs btn-primary pull-right">
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
                            
                            <td>
                            	<a class="move" href="${board.bno}">${board.title} </a>
                            </td>
                            
                            <td>${board.writer}</td>
                            <td><fmt:formatDate value="${board.regdate}" 
                            pattern="yyyy-MM-dd"  /></td>
                            <td><fmt:formatDate value="${board.updateDate}" 
                            pattern="yyyy-MM-dd"  /></td>
                        </tr>
                     </c:forEach>   
                </table>
         
          <!-- 페이징처리 -->
          <div class="pull-right">
			  <ul class="pagination">
			  	
			  	<c:if test="${pageMaker.prev}">
			    	<li class="page-item"><a class="page-link" href="${pageMaker.startPage-1}">Previous</a></li>
			    </c:if>
			   
			    <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
			    	<li class="page-item  ${pageMaker.cri.pageNum == num ? "active" : ""}" >
			    		<a class="page-link" href="${num}">${num}</a>
			    	</li>
			    </c:forEach>
			  
			    <c:if test="${pageMaker.next}">
			   	 <li class="page-item"><a class="page-link" href="${pageMaker.endPage+1 }">Next</a></li>
			    </c:if>
			  </ul>
		  </div>      
          <!-- /페이징처리 --> 
          
          <form id="actionForm" action="/board/list" method="get">
          	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
          	<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
          </form>     
                
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
		
		history.replaceState({}, null, null);
		
		//모달창
		function checkModal(result){
			if(result === "" || history.state){
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
		
		
		//페이지 버튼 클릭 이동
		var actionForm = $("#actionForm");
		$(".page-item a").on("click",function(e){
			e.preventDefault();
			
			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
 			actionForm.submit(); 
		});
		
		
		//조회하고 리스트 화면으로 이동할 때 기본 pagenum 유지
		$(".move").on("click", function(e){
			e.preventDefault();
			actionForm.append("<input type='hidden' name='bno' value='" + $(this).attr("href")+ "'>");
			actionForm.attr("action", "/board/get");
			actionForm.submit();
		});
		
	});
</script>  
  
  
  
  
  
  
  
  
            
<%@ include file="../includes/footer.jsp" %> 