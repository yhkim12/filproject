var CALL_AJAX = {
	reqAjax : function(ajaxOpt) {
		var opt = $.extend({
			type : 'GET',
			url : '',
			cache : false,
			dataType : 'json',
			data : {}
		}, ajaxOpt);

		$.ajax(opt);
	},
	sampleAjax : function(param, successFunc, type) {
		this.reqAjax({
			type : 'GET',
			async : false,
			url : '/sample/index.ajax',
			dataType : type || 'json',
			data : param,
			success : function(result) {
				successFunc(result);
			}
		});
	},
	callAjax : function(param, successFunc, type, url, method, sync) {
		this.reqAjax({
			type : method || 'GET',
			async : sync || false,
			url : url,
			dataType : type || 'json',
			cache : false,
			data : param,
			beforeSend: function(){
				// displayLodingBar("show");
		   },
			success : function(result) {
				// displayLodingBar("hide");
				successFunc(result);
			},
			error: function(xhr,status,error){
				// displayLodingBar("hide");
				alert("code:"+xhr.status);
			}
		});
	},
	uploadAjax : function(param, successFunc, type, url, method, sync) {
		this.reqAjax({
			type : method || 'GET',
			async : sync || false,
			url : url,
			dataType : type || 'json',
			data : param,
			processData: false,
			contentType: false,
			beforeSend: function(){
				// displayLodingBar("show");
			},
			success : function(result) {
				// displayLodingBar("hide");
				successFunc(result);
			},
			error: function(xhr,status,error){
				// displayLodingBar("hide");
				alert("code:"+xhr.status);
			}
		});
	}
};
