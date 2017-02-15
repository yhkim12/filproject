;
/**
 * jquery.callAjax.js
 *
 * useage : $.callAjax.get.json(url [, data], callbackFunction[,errorCallback]);
 *
 * @author Brandon
 * @since 2012.03.19
 * @version 0.9.2
 * @date 2015.01.30
 */
var $jqXhr = null;
(function($) {
	$.callAjax = function(url) {
		return doAjax('GET', 'text', url);
	};
	$.callAjax.get = [];
	$.callAjax.post = [];

	$.callAjax.dataTypes = [ 'json', 'xml', 'jsonp', 'html' ];
	$.callAjax.defaults = {
		async : false,
		cache : false,
		type : 'GET',
		timeout : 2000,
		url : '',
		data : undefined,
		dataType : 'text',
		success : function(data, textStatus, jqXHR) {

		},
		error : function(jqXHR, textStatus, errorThrown) {
			$jqXhr = null;
			try {
				ga('send', 'exception', {
					'exDescription' : errorThrown
				});
			} catch (ex) { /* do nothing */ }

			// var errorMsg = '[Server Error]<br />status:'+textStatus+'<br
			// />errorThrown:'+errorThrown+'<br />';
			var errorMsg = '[Server Error]<br />' + errorThrown + '';
			try {
				jNoti.error(errorMsg);
			} catch (ex) {
				errorMsg.replace('<br />', '\n');
				alert(errorMsg);
			}
		},
		complete : function(jqXHR, textStatus) {
			$jqXhr = null;
		},
		// asyncMsg : '처리중인 작업이 있습니다.\n계속하시겠습니까?'
		asyncMsg : ''
	};

	$.each($.callAjax.dataTypes,
			function(i, dataType) {
				$.callAjax.get[dataType] = function(url, data, callback,
						errorCallback) {
					return doAjax('GET', dataType, url, data, callback,
							errorCallback);
				};

				$.callAjax.post[dataType] = function(url, data, callback,
						errorCallback) {
					return doAjax('POST', dataType, url, data, callback,
							errorCallback);
				};
			});

	function doAjax(type, dataType, url, data, callback, errorCallback) {
		if ($jqXhr != null && $.callAjax.defaults.async
				&& $.callAjax.defaults.asyncMsg) {
			if (confirm($.callAjax.defaults.asyncMsg)) {
				if ($jqXhr != null)
					$jqXhr.abort();
				$jqXhr = null;
			} else {
				return $jqXhr;
			}
			// alert('$.callAjax.jqXhr != null');
			// return null;
		}

		// shift arguments if data argument was omitted
		if (jQuery.isFunction(data)) {
			errorCallback = callback;
			callback = data;
			data = undefined;
		}
		var opts = {
			type : type,
			dataType : dataType,
			url : url,
			data : data,
			success : callback,
			error : errorCallback
		};
		opts = $.extend({}, $.callAjax.defaults, opts || {});

		try {
			ga('send', 'event', 'callAjax', type, url);
		} catch (ex) { /* do nothing */ }

		return $jqXhr = jQuery.ajax(opts);
	}

})(jQuery);