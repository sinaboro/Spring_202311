console.log("Reply Module..........");

var replyService = (function() {
	
	function add(reply, callback, error){
		console.log("reply.........");
		$.ajax({
			type: 'post',
			url: '/replies/new',
			data: JSON.stringify(reply),
			contentType: "application/json; charset=utf-8",
			success: function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error: function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		});
	}  // end add

  function getList(param, callback, error){
		var bno = param.bno;
		var page = param.page || 1;

		$.ajax({
			type: "get",
			url: "/replies/pages/"+bno + "/" + page,
			success: function(data, status, xhr){
				if(callback){
					callback(data);
				}
			},
			error: function(xhr, status, er){
				if(error){
					error(er);
				}
			}

		});
	}


	return {
		add : add,
		getList : getList
	};

})();