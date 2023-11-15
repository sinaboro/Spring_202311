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
	} // end getList

	function remove(rno, callback, error){
		$.ajax({
			type: "delete",
			url: "/replies/" + rno,
			success : function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		});
	} // end remove

	function update(reply, callback, error){
		console.log("RNO: " + reply.rno);

		$.ajax({
			type: "put",
			url: "/replies/" +reply.rno,
			data: JSON.stringify(reply),
			contentType: "apllication/json; charset=utf-8",

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
	} //end update

	function get(rno, callback, error){
		console.log("get >>> " + rno);
		
		$.ajax({
			type: "get",
			url: "/replies/"+rno,
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
	} //end get

	return {
		add : add,
		getList : getList,
		remove: remove,
		update: update,
		get: get
	};

})();