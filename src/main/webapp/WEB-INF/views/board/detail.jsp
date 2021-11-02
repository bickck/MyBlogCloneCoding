<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">

	<button class="btn btn-secondary" onclick="history.back()">���ư���</button>
	<c:if test="${board.user.id == principal.user.id}">
		<button id="btn-update" class="btn btn-waring">����</button>
		<button id="btn-delete" class="btn btn-danger">����</button>
	</c:if>
	<br /> <br />
	<div class="form-group">
		�� ��ȣ:<span id="id"><i>${board.id }</i></span> �� �ۼ���:<span id="id"><i>${board.username }</i></span>
	</div>
	<br />
	<div>
		<h3>${board.title}</h3>
	</div>
	<div class="form-group">
		<label for="title">TiTle:</label>
		<h3>${board.title}</h3>
	</div>
	<hr />
	<div class="form-group">
		<label for="comment">Content:</label>
		<div>${board.content}</div>
	</div>
	<hr />


</div>


<script src="/js/board.js" />
<%@ include file="../layout/footer.jsp"%>