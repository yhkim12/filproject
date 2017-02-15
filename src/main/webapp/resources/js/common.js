$(function() {

	//type number에 특수문자 입력 방지
	$('input[type=number]').on('keydown', function () {
		event = event || window.event;
		var keyID = (event.which) ? event.which : event.keyCode;
		if ( (keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105) || keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 )
			return;
		else
			return false;
	});
});

//window 팝업 열기
//@param	title	팝업 메뉴 이름
//@param	url		팝업 주소
//@param	name	팝업 이름
//@param	options	팝업창 설정
function openWindowPopup(title, url, name, options) {
	var popupObj = window.open(url, name, options);
	popupObj[popupObj.addEventListener ? 'addEventListener' : 'attachEvent'](
		(popupObj.attachEvent ? 'on' : '') + 'load', function() {
			localStorage.setItem('popup_title', title); //팝업 타이틀 담기
		  	//popupObj.document.getElementById('popup_title_top').innerText = title;
		}, false
	);
}

/*
* @param diff
* 3m : 최근 3개월 , 1m : 최근 한달, 1d : 오늘, 7d : 최근 한 주,
* tw : 이번주, lw : 지난주, tm : 이번달, lm : 지난달
*/
function changeCalendar(diff, obj1, obj2, delimiter, returnFunc) {
	var sdt = new Date();
	var edt = new Date();

	var smonth = sdt.getMonth();
	var sday = sdt.getDate();

	var emonth = edt.getMonth();

	var weekday = sdt.getDay();

  	if (diff == '3m') {
  		sdt.setMonth(smonth - 3);
  	} else if (diff == '1m') {
  		sdt.setMonth(smonth - 1);
  	} else if (diff == '7d') {
  		sdt.setDate(sday - 7);
	} else if (diff == '1d') {
		sdt.setDate(sday);
  	} else if (diff == 'tw') {
  		sdt.setDate(sday - weekday + 1);
  		edt.setDate(edt.getDate() - weekday + 7);
  	} else if (diff == 'lw') {
  		sdt.setDate(sday - weekday - 6);
  		edt.setDate(edt.getDate() - weekday);
  	} else if (diff == 'tm') {
  		sdt.setDate(1);
  		edt.setMonth(emonth + 1);
  		edt.setDate(0);
  	} else if (diff == 'lm') {
  		sdt.setMonth(smonth - 1);
  		sdt.setDate(1);
  		edt.setMonth(emonth);
  		edt.setDate(0);
  	} else {
  		$('#sdate').val('');
  		$('#edate').val('');
  		return;
  	}

  	var syear = sdt.getFullYear();
  	smonth = sdt.getMonth()+1;
  	smonth = ((smonth < 10) ? "0" + smonth : smonth);
  	sday = sdt.getDate();
  	sday = ((sday < 10) ? "0" + sday : sday);

  	delimiter = (!delimiter) ? "-" : delimiter;

  	var obj1Value = syear + delimiter + smonth + delimiter + sday;
  	obj1.val(obj1Value);

	var eyear = edt.getFullYear();
  	emonth = edt.getMonth()+1;
  	emonth = ((emonth < 10) ? "0" + emonth : emonth);
  	var eday = edt.getDate();
  	eday = ((eday < 10) ? "0" + eday : eday);

  	var obj2Value = eyear + delimiter + emonth + delimiter + eday;
  	obj2.val(obj2Value);

  	if (typeof returnFunc == 'function') {
  		returnFunc(obj1Value, obj2Value);
  	}
}

/**
 *	공개 여부 변경 함수 - ajax
 */
function doToggleDispYn(param, objBtn, url) {

	var oldValue = $(objBtn).data('val');
	var arrStr = ['노출', '비노출'];

	param['dispYn'] = (oldValue == 'Y' ? 'N' : 'Y' );


 	if (confirm( (oldValue == 'Y' ? arrStr[1]:arrStr[0]) + '로 변경하시겠습니까?')) {
 		//var param = {diyCaseTypeIdx: diyCaseTypeIdx, dispYn : (oldValue == 'Y' ? 'N' : 'Y') };
		CALL_AJAX.callAjax(param
				, function (data) {
					if (data.status == 'fail') {
						alert(data.msg);
						return;
					}

					$(objBtn).text((oldValue == 'Y' ? arrStr[0]:arrStr[1]) + '하기');
					$(objBtn).data('val', (oldValue == 'Y' ? 'N' : 'Y'));
					$(objBtn).siblings('div').text(oldValue == 'Y' ? arrStr[1]:arrStr[0]);
				}
				, 'json'
				, url, 'POST');
 	}
}

/**
 *	검색 영역 초기화
 */
function resetForm() {
	$('[name^=sch]').each(function (index) {
		if ($(this).prop("tagName").toLowerCase() == 'select') {
			$(this).find('option:first').prop('selected', true);
		} else {
			if ($(this).attr('type') == 'radio') {
				if ($(this).index() == '0') {
					$(this).prop('checked', true);
				}
			} else {
				$(this).val('');
			}
		}
		
		doSearch(); //재 검색
		
	});
}

/**
 * 검색시 순서 변경 버튼 여부
 */
function showSortBtn() {
	var sortBtnYn = true;
	$('[name^=sch]').each(function (index) {
		if ($(this).prop("tagName").toLowerCase() == 'select') {
			if ($(this).find('option:selected').index() != 0) {
				sortBtnYn = false;
			}
		} else {
			if ($(this).attr('type') == 'radio') {
				if ($(this).is(":checked") && $(this).index() != '0') {
					sortBtnYn = false;
					return;
				}
			} else {
				if (this.value != '') {
					sortBtnYn = false;
					return;
				}
			}
		}
	});

	return sortBtnYn;
}

/**
 * 순서 정렬
 */
function initSortable(url, fnCallback) {
	//검색 조건이 있을시 순서변경버튼 숨김
	if (showSortBtn()) {
		$('.sortable-handle').show();
	} else {
		$('.sortable-handle').hide();
	}

	$("#sortable").sortable({
        cursor: 'pointer',
        opacity: 0.6,
        handle : '.sortable-handle',
        cancel: '',
        update: function( event, ui ) {
            var sortStr = $(this).sortable('toArray').toString();
			var param = {'sortStr': sortStr};
			// 노출 순서 변경 AJAX
			CALL_AJAX.callAjax(param, fnCallback, 'json', url, 'POST');
        }
    });
}

//노출순서변경 성공 콜백함수
var sortCallbackFunc = function(data) {
	if (data.status == 'success') {
		$.each($('.ui-sortable tr'), function(index, thisTr) {
			//$(this).attr('id', 'sortable_' + (index + 1));
		});
	}

	alert(data.msg);
}

/**
 * type-number maxlength 체크
 */
function maxLengthCheck(obj){
	if (obj.value.length > obj.maxLength){
		obj.value = obj.value.slice(0, obj.maxLength);
	}
}