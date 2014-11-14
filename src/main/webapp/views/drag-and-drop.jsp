<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Drag And Drop Exemplo</title>

<style type="text/css">
#div1 {
	width: 350px;
	height: 70px;
	padding: 10px;
	border: 1px solid #aaaaaa;
	top:20px;
	position:relative;
	
}

#div2 {
 border:2px dashed gray;
 height: 80px;
 width: 500px;
}
</style>
</head>
<body>

	<p>Drag the W3Schools image into the rectangle:</p>

	<p>Arquivo:</p>
	<input type="file" alt="Arquivo anexo" multiple id="div2"/>
	<br>
	<div id="div1" ondrop="drop(event)" ondragover="allowDrop(event)" ></div>
	<br>
	<img id="drag1" src="resources/img/logo_2cm.jpg" draggable="true"
		ondragstart="drag(event)" width="336" height="69">

	<script>
		function allowDrop(ev) {
			ev.preventDefault();
		}

		function drag(ev) {
			ev.dataTransfer.setData("Text", ev.target.id);
		}

		function drop(ev) {
			ev.preventDefault();
			var data = ev.dataTransfer.getData("Text");
			ev.target.appendChild(document.getElementById(data));
		}

	
		function desabilitarDragDrop() {
			window.addEventListener("dragover", function(e) {
				e = e || event;
				e.preventDefault();
			}, false);
			 window.addEventListener("drop", function(e) {
				e = e || event;
				e.preventDefault();
			}, false);
		}
	</script>
</body>
</html>