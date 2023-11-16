console.log("Reply Module..........");

var replyService = (function() {
	
	function add(reply, callback, error){
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
		console.log("reply >> " +reply.reply);
		console.log("rno >> " + reply.rno);

		$.ajax({
			type: "put",
			url: "/replies/" +reply.rno,
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


	function displayTime(timeValue){

		var today = new Date();

		var gap = today.getTime() - timeValue;
		var dateObj = new Date(timeValue);

		console.log("dateObj >> " + dateObj);
		var str="";

		if(gap < (1000*60*60*24)){ //24시간(하루)
			var hh = dateObj.getHours();
			var mi = dateObj.getMinutes();
			var ss = dateObj.getSeconds();

			return [ (hh >9 ? '' : '0') + hh, ":" , (mi > 9? '' : '0') + mi , ":" , (ss > 9? '' : '0') + ss].join("") ;

		}else{
			var yy = dateObj.getFullYear();
			var mm = dateObj.getMonth() +1;
			var dd = dateObj.getDate();

			return [ yy, "/", (mm > 9? '' : "0")+ mm , "/" , (dd > 9? '' : '0')+dd].join("");
		}

	} //end displayTime

	return {
		add : add,
		getList : getList,
		remove: remove,
		update: update,
		get: get,
		displayTime: displayTime
	};

})();