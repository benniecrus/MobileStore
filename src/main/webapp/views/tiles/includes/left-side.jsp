<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

  <style>
	body {
    font-family: "Lato", sans-serif;
}

.sidenav {
    height: 100%;
    width: 0;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    background-color: #111;
    overflow-x: hidden;
    transition: 0.5s;
    padding-top: 60px;
}

.sidenav a {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    color: #818181;
    display: block;
    transition: 0.3s;
}

.sidenav a:hover {
    color: #f1f1f1;
}

.sidenav .closebtn {
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 36px;
    margin-left: 50px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
</style>
</head>
<body>

<div id="manufactureNav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeManufacture()">&times;</a>
  <a href="#">Apple</a>
  <a href="#">Samsung</a>
</div>

<div id="categoryNav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeCategory()">&times;</a>
  <a href="#">Laptop</a>
  <a href="#">Mobile</a>
</div>
<span class="d-block" style="font-size:20px;cursor:pointer" onclick="openManufacture()">&#9776; Manufacture</span>
<span class="d-block" style="font-size:20px;cursor:pointer" onclick="openCategory()">&#9776; Category</span>
</body>
<script>
function openManufacture() {
    document.getElementById("manufactureNav").style.width = "250px";
}

function closeManufacture() {
    document.getElementById("manufactureNav").style.width = "0";
}

function openCategory() {
    document.getElementById("categoryNav").style.width = "250px";
}

function closeCategory() {
    document.getElementById("categoryNav").style.width = "0";
}
</script>
</html>