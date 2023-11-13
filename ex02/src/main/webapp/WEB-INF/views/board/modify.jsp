<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../includes/header.jsp" %>
    
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Board Modify Page</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Board Modify Page
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
            	<form role="form" action="/board/modify" method="post">
	           	
	           		<input type="hidden"  name="pageNum" value="${cri.pageNum}">
           			<input type="hidden"  name="amount" value="${cri.amount}">
	           		
	           		<div class="form-group">
	           			<label>Bno</label>
	           			<input class="form-control" name="bno" value="${board.bno}"  readonly="readonly">
	           		</div>
	           		
	           		<div class="form-group">
	           			<label>Title</label>
	           			<input class="form-control" name="title" value="${board.title}" >
	           		</div>
	           		<div class="form-group">
	           			<label>Text area</label>
	           			<textarea class="form-control" rows="3" name="content" >${board.content}</textarea>
	           		</div>
	           		<div class="form-group">
	           			<label>Writer</label>
	           			<input class="form-control" name="writer" value="${board.writer}"  readonly="readonly">
	           		</div>
	           
	           		<button type="submit" data-abcd="modify" class="btn btn-default">Modify</button>
	
	           		<button type="submit" data-abcd="remove" class="btn btn-danger">Remove</button>
	           
	           		<button type="submit" data-abcd="list" class="btn btn-info">List</button>
           		</form>
            </div> <!-- /.panel-body -->
            
        </div> <!-- /.panel -->
        
    </div>  <!-- /.col-lg-12 -->
   
</div> <!-- /.row -->

<script type="text/javascript">

$(document).ready(function(){
	
	var formObj = $("form");
	
	$("button").on("click", function(e){
		e.preventDefault(); //이동 중지
		
		var operation = $(this).data("abcd");
		//console.log(operation);
		
		if(operation === "remove"){
			formObj.attr("action", "/board/remove")
		}else if(operation === "list"){
			formObj.attr("action", "/board/list").attr("method","get");
			formObj.empty();
		}
		
		formObj.submit();
	});
});

</script>















            
<%@ include file="../includes/footer.jsp" %> 