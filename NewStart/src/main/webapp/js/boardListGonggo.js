//----------------------------------------------- 삭제 -----------------------------------------------
function del(val){
	alert("삭제할 seq : " + val);
	location.href="./delGonggo.do?seq="+val;
}


function checkAll(bool){
	var chkVals = document.getElementsByName("chkVal");
	for (var i = 0; i < chkVals.length; i++) {
		chkVals[i].checked = bool;
	}
}

function chkbox(){
	var chkVals = document.getElementsByName("chkVal");
	var n = 0;
	for (var i = 0; i < chkVals.length; i++) {
		if(chkVals[i].checked){
			n++;
		}
	}
	if(n>0){
		document.getElementById("frm").action="./multiDel.do";
		
	} else {
		swal("게시글 오류", "삭제할 값이 없습니다.");
		return false;
	}
	
}


//---------------------------------------------- 글 수정 --------------------------------------------------------


// 이거하나로 수정페이지로 이동시키기
function modify(val){
	location.href = "./modifyFormGonggo.do?gonggo_seq="+val;
}




function update(){
	var frm = document.getElementById("frmModify");
	// 해당 글의 seq를 뽑아 보내자 몇개가 됐든간에 처리가능하게
	var title = $("#title").val();
	var content = $("#content").val();
	var Gonggo_seq = $("#Gonggo_seq").val();
	frm.action="./modifyGonggo.do?title="+title+"&content="+content+"&Gonggo_seq="+Gonggo_seq;
	if(title == ""){ // 자바랑 null 확인하는 방법이 다르다.
		swal("글 수정 오류", "제목은 필수입니다.");
	}else if(content == ""){
		swal("글 수정 오류", "내용은 필수입니다.");
	}else {
		alert(frm.method);
		frm.submit();
	}
}



// -------------------------------------- 글 작성 관리 --------------------------------------------------------
function GonggoCreate(){
	if($("#userType").val() == "M"){
		location.href = "./boardInsertM.do";
	} else {
		location.href = "./boardInsertT.do";
	}
}
