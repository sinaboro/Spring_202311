<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../includes/header.jsp" %>
    
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Board Read</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>

<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Board Read page
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
           		<div class="form-group">
           			<label>Bno</label>
           			<input class="form-control" name="bno" value="${board.bno}"  readonly="readonly">
           		</div>
           		
           		<div class="form-group">
           			<label>Title</label>
           			<input class="form-control" name="title" value="${board.title}"  readonly="readonly">
           		</div>
           		<div class="form-group">
           			<label>Text area</label>
           			<textarea class="form-control" rows="3" name="content"  readonly="readonly">${board.content}</textarea>
           		</div>
           		<div class="form-group">
           			<label>Writer</label>
           			<input class="form-control" name="writer" value="${board.writer}"  readonly="readonly">
           		</div>
           
           		<button data-oper="modify" class="btn btn-default">Modify</button>
           		<button data-oper="list" class="btn btn-info">List</button>
           		
           		<form id="operForm" action="/board/modify" method="get">
           			<input type="hidden" id="bno" name="bno" value="${board.bno}">
           			<input type="hidden"  name="pageNum" value="${cri.pageNum}">
           			<input type="hidden"  name="amount" value="${cri.amount}">
           			
           			<input type="hidden" name="type" value="${cri.type}">
          			<input type="hidden" name="keyword" value="${cri.keyword}">
           		</form>
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->


 <!-- -------- 댓 글 ------------ -->
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
               <i class="fa fa-comments fa-fw"></i>Reply
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
           		
           		<ul class="chat">
           			<li class="left clearfix" data-rno='12'>
           				<div>
           					<div class="header">
           						<strong class="primary-font">user00</strong>
           						<small class="pull-right text-muted">2023-11-16 11:20</small>
           					</div>
           					<p>Good Job!!</p>
           				</div>
           			</li>
           		</ul>
           		
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row --> 
 <!-- ------------------------- -->
 
 
 
<script type="text/javascript" src="/resources/js/reply.js"></script>
 
<script>
	
	var bnoValue = '${board.bno}';  //1015842
	var replyUL = $(".chat");
	
	console.log("bnoValue : " + bnoValue);
	
	showList(1);
	
	function showList(page){
		
		replyService.getList({bno:bnoValue, page: page||1}, function(list){
			var str="";
			
			if(list == null || list.length==0){
				replyUL.html("");
				return;
			}
			
			for(var i=0, len=list.length || 0; i<len; i++){
				
				str += "<li class='left clearfix' data-rno='"+list[i].rno +"'>";
				str += "<div><div class='header'>";
				str += "<strong class='primary-font'>"+ list[i].replyer +"</strong>";
				str += "<small class='pull-right text-muted'>"+ list[i].replyDate +"</small>";
				str += "</div><p>"+ list[i].reply +"</p>";
				str += "</div></li>";
			}
			replyUL.html(str);
		}); //end function
		
	} //end showList
	
	
	
	/* replyService.get(
		48,
		function(data){
			console.log(data);
		},
		function(err){
			console.log(err);
		}
	); */
	/* replyService.update(
			{rno:38, reply:"Modify Reply...."},
			function(data){
				alert("수정완료 >>" + data);
			},
			function(er){
				alert("실패 >> " + er);
			}
	); */
	/* replyService.remove(
		34, 
		function(data){
			console.log(data);
			if(data === "success"){
				alert("REMOVED");
			}
		},
		function(err){
			alert("ERROR....");
		}
	); */
	/* replyService.getList({bno:bnoValue, page:1} , function(list){
		for(var i=0, len = list.length || 0; i<len ; i++){
			console.log(list[i]);
		}
	}); */
	
	/* var addValue = {
			reply:"JS Test", 
			replyer: "tester", 
			bno:bnoValue	
	};
	
	
	replyService.add(addValue , function(result){
		alert("RESULT : " + result);
	});
	 */
</script>
 
    
<script>
	$(document).ready(function(){
		var operForm = $("#operForm");
		
		$("button[data-oper='modify']").on("click", function(e){
			operForm.attr("action", "/board/modify").submit();
		});

		$("button[data-oper='list']").on("click", function(e){
			operForm.find("#bno").remove();
			operForm.attr("action", "/board/list").submit();
		});
		
		
	});
</script>   
    
    
    
    
    
    
    
    
    
    
    
    
    
            
<%@ include file="../includes/footer.jsp" %> 