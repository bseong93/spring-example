function ajaxTest() {
	$.ajax({
		url : CONTEXT_PATH + "/boardListGet",
		type : "POST",
		data : {},
		dataType : "json",
		async : true,
		success : function(data) {
			console.log("ajax success");
			console.log(data);
		},
		error : function() {
			console.log("ajax error");
		}
	});
}
